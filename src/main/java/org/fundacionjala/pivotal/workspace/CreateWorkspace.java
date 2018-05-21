package org.fundacionjala.pivotal.workspace;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * Class for create a Project.
 */
public class CreateWorkspace extends Base {

    @FindBy(how = How.ID, using = "create-workspace-button")
    private WebElement buttonNewWorkspaceProject;

    @FindBy(how = How.CSS, using = ".tc-form__input")
    private WebElement txtWorkspaceName;

    @FindBy(how = How.CSS, using = ".pvXpn__Button--positive")
    private WebElement buttonCreateWorkspace;

    @FindBy(how = How.CSS, using = ".WorkspaceTile:last-child .WorkspaceTile__name")
    private WebElement lastWorkspaceCreated;

    private String workspaceName;


    /**
     * Method for set Workspace name.
     * @return ButtonCreateWorkspace.
     */
    private WebElement getButtonCreateWorkspace() {
        return CommonMethods.waitWebElement(buttonNewWorkspaceProject);

    }

    /**
     * Method for set Workspace name.
     * @return ButtonCreateWorkspace.
     */
    private WebElement getButtonSaveWorkspace() {
        return CommonMethods.waitWebElement(buttonCreateWorkspace);

    }


    /**
     * Method for set Workspace name.
     * @return ButtonCreateWorkspace.
     */
    private WebElement getLastWorkspaceCreated() {
        return CommonMethods.waitWebElement(lastWorkspaceCreated);

    }

    /**
     * Method for set Workspace name.
     * @return ButtonCreateWorkspace.
     */
    public String getLastWorkspaceCreatedText() {
        return getLastWorkspaceCreated().getText();

    }

    /**
     * Method for set Workspace name.
     * @param workspaceName String.
     */
    private void setTxtWorkspaceNameName(final String workspaceName) {
        CommonMethods.setWebElement(txtWorkspaceName, workspaceName);

    }

    /**
     * Method for press click buttton for create a new workspace.
     */
    private void clickButtonCreateWorkspace() {
        CommonMethods.clickWebElement(this.getButtonCreateWorkspace());
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonSaveWorkspace() {
        CommonMethods.clickWebElement(this.getButtonSaveWorkspace());
    }

    /**
     * Method to Create workspace .
     * @param workspaceName String.
     */
    public final void createWorkspace(final String workspaceName) {
        this.clickButtonCreateWorkspace();
        this.setTxtWorkspaceNameName(workspaceName);
        this.clickButtonSaveWorkspace();
    }

    /**
     * This method set the workspace name variable.
     * @param workspaceName the value to be set.
     */
    public void setWorkspaceName(final String workspaceName) {
        this.workspaceName = workspaceName;
    }

    /**
     * This method return the workspace name variable.
     * @return the variable value.
     */
    public String getWorkspaceName() {
        return workspaceName;
    }


}