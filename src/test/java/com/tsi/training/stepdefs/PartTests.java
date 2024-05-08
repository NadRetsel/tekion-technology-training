package com.tsi.training.stepdefs;

import com.tsi.training.controller.PartController;
import com.tsi.training.dto.PartDTO;
import com.tsi.training.entity.Part;
import com.tsi.training.service.PartService;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(Cucumber.class)
@AutoConfigureMockMvc
public class PartTests {

    @Autowired private MockMvc mockMvc;
    private MvcResult mvcResult;

    @MockBean private PartController partController;
    @MockBean private PartService partService;

    private List<PartDTO> partDTOList;
    private String description;


    @Test
    public void placeholder() throws Exception
    {
        this.mockMvc.perform(get("/parts/{description}", "item 1"))
                .andReturn();
    }

    @DataTableType
    public PartDTO convert(Map<String, String> entry){
        System.out.println(entry.get("description"));
        return PartDTO.builder()
                .description(entry.get("description"))
                .price(Double.valueOf(entry.get("price")))
                .build();
    }


    @Given("a list of PartDTOs")
    public void givenPartDTOList(List<PartDTO> partDTOList)
    {
        this.partDTOList = partDTOList;
    }

    @When("save to Part Repository")
    public void saveToPartRepository() throws Exception {
        System.out.println(this.mockMvc);
        this.mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/parts/{description}", "item 1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn()
                //.andExpect(status().isOk())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty())
                ;
        /*
        System.out.println(this.partController);

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.partController).build();
        System.out.println(this.mockMvc);

        System.out.println(new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(this.partDTOList));

        this.mvcResult = this.mockMvc
                .perform(post("/parts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new GsonBuilder()
                                .setPrettyPrinting()
                                .create()
                                .toJson(this.partDTOList)))
                .andDo(print())
                .andReturn();

         */
    }

    @Then("Part Repository is populated")
    public void assertPopulatedPartRepository()
    {
       Assert.assertNotNull(this.mvcResult.getResponse());
    }

    // ============================================================

    @Given("Part Entity to search has description {string}")
    public void setProductDTODescription(String description)
    {
        this.description = description;
    }


    @When("find Part Entity with matching description in Part Repository")
    public void findPartInRepository() throws Exception
    {
        this.mvcResult = this.mockMvc
                .perform(get("/parts/{description}", this.description))
                .andDo(print())
                .andReturn();
    }

    @Then("expect non-null Part Entity")
    public void assertNotNullPartEntity()
    {
        Assert.assertNotNull(this.mvcResult.getResponse());
    }


    /*
    @Mock private PartRepository partRepository;
    @InjectMocks private PartService partService;

    private String inputDescription;
    private String inputPrice;
    private Part part;



    @Given("Part DTO description {string}")
    public void setProductDTODescription(String description)
    {
        this.inputDescription = description;
    }

    @And("Part DTO price {string}")
    public void setProductDTOPrice(String price)
    {
        this.inputPrice = price;
    }

    @When("attempt to create new Part Entity")
    public void attemptProductSave()
    {
        MockitoAnnotations.openMocks(this);

        try
        {
             this.part = Part.builder()
                    .description(this.inputDescription)
                    .price(Double.valueOf(this.inputPrice))
                    .build();

            this.partRepository.save(this.part);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            this.part = null;
        }
    }


    @Then("Part Entity should be filled")
    public void filledPartEntity()
    {
        Assert.assertNotNull(this.part);
    }

    @Then("Part Entity should not be created")
    public void emptyPartEntity()
    {
        Assert.assertNull(this.part);
    }

    @And("Part Repository should have {int} items")
    public void countPartRepository(int expectedCount)
    {
        Assert.assertEquals(expectedCount, this.partRepository.findAll().size());
    }

     */


}
