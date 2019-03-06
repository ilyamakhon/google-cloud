package bean;

import org.openqa.selenium.WebElement;

import java.util.Objects;

public class WebElementOptionModel {

    private String XPath;
    private String optionToBeSelected;
    private WebElement actionElement;
    private WebElement elementWaitingForClick;
    private WebElement elementWaitingToBeVisible;

    public String getXPath() {
        return XPath;
    }

    public void setXPath(String XPath) {
        this.XPath = XPath;
    }

    public String getOptionToBeSelected() {
        return optionToBeSelected;
    }

    public void setOptionToBeSelected(String optionToBeSelected) {
        this.optionToBeSelected = optionToBeSelected;
    }

    public WebElement getActionElement() {
        return actionElement;
    }

    public void setActionElement(WebElement actionElement) {
        this.actionElement = actionElement;
    }

    public WebElement getElementWaitingForClick() {
        return elementWaitingForClick;
    }

    public void setElementWaitingForClick(WebElement elementWaitingForClick) {
        this.elementWaitingForClick = elementWaitingForClick;
    }

    public WebElement getElementWaitingToBeVisible() {
        return elementWaitingToBeVisible;
    }

    public void setElementWaitingToBeVisible(WebElement elementWaitingToBeVisible) {
        this.elementWaitingToBeVisible = elementWaitingToBeVisible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebElementOptionModel that = (WebElementOptionModel) o;
        return Objects.equals(XPath, that.XPath) &&
                Objects.equals(optionToBeSelected, that.optionToBeSelected) &&
                Objects.equals(actionElement, that.actionElement) &&
                Objects.equals(elementWaitingForClick, that.elementWaitingForClick) &&
                Objects.equals(elementWaitingToBeVisible, that.elementWaitingToBeVisible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(XPath, optionToBeSelected, actionElement, elementWaitingForClick, elementWaitingToBeVisible);
    }

    @Override
    public String toString() {
        return "WebElementOptionModel{" +
                "XPath='" + XPath + '\'' +
                ", optionToBeSelected='" + optionToBeSelected + '\'' +
                ", actionElement=" + actionElement +
                ", elementWaitingForClick=" + elementWaitingForClick +
                ", elementWaitingToBeVisible=" + elementWaitingToBeVisible +
                '}';
    }

    public static class ModelBuilder {
        private WebElementOptionModel webElementOptionModel = new WebElementOptionModel();

        public static ModelBuilder create() {
            return new ModelBuilder();
        }

        public ModelBuilder withXPath(String XPath) {
            webElementOptionModel.XPath = XPath;
            return this;
        }

        public ModelBuilder withOptionToBeSelected(String optionToBeSelected) {
            webElementOptionModel.optionToBeSelected = optionToBeSelected;
            return this;
        }

        public ModelBuilder withActionElement(WebElement actionElement) {
            webElementOptionModel.actionElement = actionElement;
            return this;
        }

        public ModelBuilder withElementWaitingForClick(WebElement elementWaitingForClick) {
            webElementOptionModel.elementWaitingForClick = elementWaitingForClick;
            return this;
        }

        public ModelBuilder withElementWaitingToBeVisible(WebElement elementWaitingToBeVisible) {
            webElementOptionModel.elementWaitingToBeVisible = elementWaitingToBeVisible;
            return this;
        }

        public WebElementOptionModel build() {
            return webElementOptionModel;
        }
    }
}
