package Model;

/* Stores all the information of a given item object */

public class Item {

    private String id;
    private String itemName;
    private String description;
    private String acquired;
    private String acquired2;
    private String itemBoost;
    private String itemBenefit;
    private String itemUse;
    private String Craft;

    public Item(String id, String itemName, String description, String acquired, String acquired2, String itemBoost, String itemBenefit, String itemUse, String craft) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.acquired = acquired;
        this.acquired2 = acquired2;
        this.itemBoost = itemBoost;
        this.itemBenefit = itemBenefit;
        this.itemUse = itemUse;
        Craft = craft;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAcquired() {
        return acquired;
    }

    public void setAcquired(String acquired) {
        this.acquired = acquired;
    }

    public String getAcquired2() {
        return acquired2;
    }

    public void setAcquired2(String acquired2) {
        this.acquired2 = acquired2;
    }

    public String getItemBoost() {
        return itemBoost;
    }

    public void setItemBoost(String itemBoost) {
        this.itemBoost = itemBoost;
    }

    public String getItemBenefit() {
        return itemBenefit;
    }

    public void setItemBenefit(String itemBenefit) {
        this.itemBenefit = itemBenefit;
    }

    public String getItemUse() {
        return itemUse;
    }

    public void setItemUse(String itemUse) {
        this.itemUse = itemUse;
    }

    public String getCraft() {
        return Craft;
    }

    public void setCraft(String craft) {
        Craft = craft;
    }

}
