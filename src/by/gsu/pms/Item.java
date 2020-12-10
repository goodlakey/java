package by.gsu.pms;

public class Item {
    private String itemTitle;
    private String itemLink;
    private String itemPubDate;

    public Item(){}

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }

    public String getItemPubDate() {
        return itemPubDate;
    }

    public void setItemPubDate(String itemPubDate) {
        this.itemPubDate = itemPubDate;
    }

    public Item(String itemTitle, String itemLink, String itemPubDate) {
        this.itemTitle = itemTitle;
        this.itemLink = itemLink;
        this.itemPubDate = itemPubDate;
    }
}
