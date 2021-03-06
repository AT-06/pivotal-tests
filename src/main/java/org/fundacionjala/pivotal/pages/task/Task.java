package org.fundacionjala.pivotal.pages.task;

import org.fundacionjala.core.selenium.Base;
import org.fundacionjala.core.selenium.CommonWebActions;
import org.fundacionjala.pivotal.pages.common.Steps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

/**
 * This class represent the Task page.
 */
public class Task extends Base {
    @FindBy(css = "div[data-focus-id=TaskAdd]")
    private WebElement addtask;

    @FindBy(css = "[data-focus-id=TaskEdit--new]")
    private WebElement taskField;

    @FindBy(css = "button[data-aid = addTaskButton]")
    private WebElement addTaskButton;

    @FindBy(css = "div[data-aid= TaskDescription]")
    private WebElement getTaskCreated;

    @FindBy(css = "button[data-aid=saveTaskButton]")
    private WebElement taskSaveButton;

    @FindBy(css = "div section > div >div > textarea")
    private WebElement taskTextArea;

    /**
     * Method to click Add task button.
     */
    public void clickAddTask() {
        CommonWebActions.clickElement(addtask);
    }

    /**
     * Method for Strategy Step Map.
     *
     * @param values Map<DescriptionsTask, String>
     * @return strategyMap.
     */
    public final Map<DescriptionsTask, Steps> getStrategyStepMap(final Map<DescriptionsTask, String> values) {
        final EnumMap<DescriptionsTask, Steps> strategyMap = new EnumMap<>(DescriptionsTask.class);
        strategyMap.put(DescriptionsTask.TASK_NAME, () ->
                setTaskDescription(values.get(DescriptionsTask.TASK_NAME)));
        return strategyMap;
    }

    /**
     * Method for set a task description.
     *
     * @param taskDescription is the description.
     */
    public void setTaskDescription(final String taskDescription) {
        CommonWebActions.setTextElement(taskField, taskDescription);
    }

    /**
     * Method to set Add task button.
     */
    public void setAddTaskButton() {
        CommonWebActions.clickElement(addTaskButton);
    }

    /**
     * Method to verify the name of the task.
     *
     * @return the task name.
     */
    public String verifyTaskName() {
        CommonWebActions.waitWebElementVisible(getTaskCreated);
        return getTaskCreated.getText();
    }

    /**
     * Method to do click on a task created.
     */
    public void clickOnTaskCreated() {
        CommonWebActions.clickElement(getTaskCreated);
    }

    /**
     * Method to do click on save task button.
     */
    public void setSaveTaskButton() {
        CommonWebActions.clickElement(taskSaveButton);
    }

    /**
     * Method to do click on task text area.
     */
    public void clickOnTaskTextArea() {
        CommonWebActions.clickElement(taskTextArea);
    }
}
