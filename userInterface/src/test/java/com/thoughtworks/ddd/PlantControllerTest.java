package com.thoughtworks.ddd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.thoughtworks.ddd.domain.crop.command.CropCreationCommand;
import com.thoughtworks.ddd.domain.crop.command.CropUpdateCommand;
import com.thoughtworks.ddd.repository.db.CropEntity;
import com.thoughtworks.ddd.repository.db.DBCropJpaClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlantControllerTest {

    @Qualifier("DBCropJpaClient")
    @Autowired
    private DBCropJpaClient dbCropJpaClient;

    @Test
    @Transactional
    @Rollback
    void query(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/plant")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(mvcResult -> {
                    String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
                    Object document = Configuration.defaultConfiguration().jsonProvider().parse(contentAsString);
                    Assertions.assertEquals(2, (Integer) JsonPath.read(document, "$.length()"));
                    Assertions.assertEquals("1", JsonPath.read(document, "$[0].id"));
                    Assertions.assertEquals("黄瓜", JsonPath.read(document, "$[0].name"));
                    Assertions.assertEquals("20kg", JsonPath.read(document, "$[0].weight"));
                    Assertions.assertEquals("2", JsonPath.read(document, "$[1].id"));
                    Assertions.assertEquals("西红柿", JsonPath.read(document, "$[1].name"));
                    Assertions.assertEquals("30kg", JsonPath.read(document, "$[1].weight"));
                });
    }


    @Test
    @Transactional
    @Rollback
    void queryOne(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/plant/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(mvcResult -> {
                    String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
                    Object document = Configuration.defaultConfiguration().jsonProvider().parse(contentAsString);
                    Assertions.assertEquals("1", JsonPath.read(document, "$.id"));
                    Assertions.assertEquals("黄瓜", JsonPath.read(document, "$.name"));
                    Assertions.assertEquals("20kg", JsonPath.read(document, "$.weight"));
                });
    }

    @Test
    @Transactional
    @Rollback
    void create(@Autowired MockMvc mvc) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String name = "土豆";
        String weight = "190kg";
        CropCreationCommand potatoCommand = CropCreationCommand.builder().name(name).weight(weight).build();
        String potatoString = mapper.writeValueAsString(potatoCommand);
        mvc.perform(MockMvcRequestBuilders.post("/plant")
                .content(potatoString)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(mvcResult -> {
                    String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
                    Object document = Configuration.defaultConfiguration().jsonProvider().parse(contentAsString);
                    Assertions.assertNotNull(JsonPath.read(document, "$.createdDate"));
                    Assertions.assertNotNull(JsonPath.read(document, "$.crop.id"));
                    Assertions.assertEquals(name, JsonPath.read(document, "$.crop.name"));
                    Assertions.assertEquals(weight, JsonPath.read(document, "$.crop.weight.value"));
                });
    }

    @Test
    @Transactional
    @Rollback
    void update(@Autowired MockMvc mvc) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String id = "1";
        String name = "土豆";
        String weight = "190kg";
        CropUpdateCommand cropUpdateCommand = CropUpdateCommand.builder().id(id).name(name).weight(weight).build();
        String potatoString = mapper.writeValueAsString(cropUpdateCommand);
        mvc.perform(MockMvcRequestBuilders.put("/plant")
                .content(potatoString)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(mvcResult -> {
                    String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
                    Object document = Configuration.defaultConfiguration().jsonProvider().parse(contentAsString);
                    Assertions.assertEquals(id, JsonPath.read(document, "$.crop.id"));
                    Assertions.assertEquals(name, JsonPath.read(document, "$.crop.name"));
                    Assertions.assertEquals(weight, JsonPath.read(document, "$.crop.weight.value"));
                });
        Optional<CropEntity> cropEntity = dbCropJpaClient.findById("1");
        Assertions.assertEquals(cropEntity.get().getName(), name);
        Assertions.assertEquals(cropEntity.get().getWeight(), weight);
    }
}

