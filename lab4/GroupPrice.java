/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/



/**
 * Price for bulk purchases
 */
// line 54 "model.ump"
// line 89 "model.ump"
public class GroupPrice
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GroupPrice Attributes
  private int priceInCents;
  private int numberToBuyToGetPrice;

  //GroupPrice Associations
  private Item item;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GroupPrice(int aPriceInCents, int aNumberToBuyToGetPrice, Item aItem)
  {
    priceInCents = aPriceInCents;
    numberToBuyToGetPrice = aNumberToBuyToGetPrice;
    boolean didAddItem = setItem(aItem);
    if (!didAddItem)
    {
      throw new RuntimeException("Unable to create groupPrice due to item");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPriceInCents(int aPriceInCents)
  {
    boolean wasSet = false;
    priceInCents = aPriceInCents;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumberToBuyToGetPrice(int aNumberToBuyToGetPrice)
  {
    boolean wasSet = false;
    numberToBuyToGetPrice = aNumberToBuyToGetPrice;
    wasSet = true;
    return wasSet;
  }

  public int getPriceInCents()
  {
    return priceInCents;
  }

  public int getNumberToBuyToGetPrice()
  {
    return numberToBuyToGetPrice;
  }

  public Item getItem()
  {
    return item;
  }

  public boolean setItem(Item aItem)
  {
    boolean wasSet = false;
    if (aItem == null)
    {
      return wasSet;
    }

    Item existingItem = item;
    item = aItem;
    if (existingItem != null && !existingItem.equals(aItem))
    {
      existingItem.removeGroupPrice(this);
    }
    item.addGroupPrice(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Item placeholderItem = item;
    this.item = null;
    placeholderItem.removeGroupPrice(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "priceInCents" + ":" + getPriceInCents()+ "," +
            "numberToBuyToGetPrice" + ":" + getNumberToBuyToGetPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "item = "+(getItem()!=null?Integer.toHexString(System.identityHashCode(getItem())):"null")
     + outputString;
  }
}