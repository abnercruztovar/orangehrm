/**
 * 
 */
package auto.orangehrm.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/deleteuser.feature", glue = "auto.orangehrm")
public class DeleteUserRunner {
}
