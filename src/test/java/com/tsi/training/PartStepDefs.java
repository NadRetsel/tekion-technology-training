package com.tsi.training.Part;

import com.tsi.training.dto.PartDTO;
import com.tsi.training.entity.Part;
import com.tsi.training.repository.PartRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PartStepDefs {

    @Mock private PartRepository partRepository;

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
        try
        {
             this.part = Part.builder()
                    .description(this.inputDescription)
                    .price(Double.valueOf(this.inputPrice))
                    .build();

            this.partRepository.save(part);
        }
        catch(Exception e)
        {
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


}
