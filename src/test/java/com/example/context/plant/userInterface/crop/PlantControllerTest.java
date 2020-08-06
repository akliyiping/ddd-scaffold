package com.example.context.plant.userInterface.crop;

import com.example.context.plant.domain.crop.command.CreationCropCommand;
import com.example.context.plant.domain.crop.event.CropCreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PlantControllerTest {

    @Test
    void query(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/plant/query")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(mvcResult -> {
                    String contentAsString = mvcResult.getResponse().getContentAsString();
                    Object document = Configuration.defaultConfiguration().jsonProvider().parse(contentAsString);
                    Assertions.assertEquals(3, (Integer) JsonPath.read(document, "$.length()"));
                    Assertions.assertEquals("黄瓜", JsonPath.read(document, "$[0].id"));
                    Assertions.assertEquals("b", JsonPath.read(document, "$[0].name"));
                    Assertions.assertEquals("c", JsonPath.read(document, "$[0].weight"));
                    Assertions.assertEquals("西红柿", JsonPath.read(document, "$[1].id"));
                    Assertions.assertEquals("b2", JsonPath.read(document, "$[2].name"));
                    Assertions.assertEquals("c2", JsonPath.read(document, "$[3].weight"));
                });
    }

    @Test
    void create(@Autowired MockMvc mvc) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String name = "土豆";
        String weight = "190kg";
        CreationCropCommand potatoCommand = CreationCropCommand.builder().name(name).weight(weight).build();
        String potatoString = mapper.writeValueAsString(potatoCommand);
        mvc.perform(MockMvcRequestBuilders.post("/plant")
                .content(potatoString)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(mvcResult -> {
                    String contentAsString = mvcResult.getResponse().getContentAsString();
                    Object document = Configuration.defaultConfiguration().jsonProvider().parse(contentAsString);
                    Assertions.assertNotNull(JsonPath.read(document, "$.createdDate"));
                    Assertions.assertNotNull(JsonPath.read(document, "$.crop.id"));
                    Assertions.assertEquals(name, JsonPath.read(document, "$.crop.name"));
                    Assertions.assertEquals(weight, JsonPath.read(document, "$.crop.weight"));
                });
    }

    @Test
    void testQuery() throws Exception {
    }
}
