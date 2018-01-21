/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/



/**
 * Price offered for members only
 */
// line 22 "model.ump"
// line 69 "model.ump"
public class SpecialPrice
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SpecialPrice Attributes
  private int priceInCents;

  //SpecialPrice Associations
  private Item item;
  private MembershipCardType membershipCardType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SpecialPrice(int aPriceInCents, Item aItem, MembershipCardType aMembershipCardType)
  {
    priceInCents = aPriceInCents;
    boolean didAddItem = setItem(aItem);
    if (!didAddItem)
    {
      throw new RuntimeException("Unable to create specialPrice due to item");
    }
    boolean didAddMembershipCardType = setMembershipCardType(aMembershipCardType);
    if (!didAddMembershipCardType)
    {
      throw new RuntimeException("Unable to create specialPrice due to membershipCardType");
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

  public int getPriceInCents()
  {
    return priceInCents;
  }

  public Item getItem()
  {
    return item;
  }

  public MembershipCardType getMembershipCardType()
  {
    return membershipCardType;
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
      existingItem.removeSpecialPrice(this);
    }
    item.addSpecialPrice(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setMembershipCardType(MembershipCardType aMembershipCardType)
  {
    boolean wasSet = false;
    if (aMembershipCardType == null)
    {
      return wasSet;
    }

    MembershipCardType existingMembershipCardType = membershipCardType;
    membershipCardType = aMembershipCardType;
    if (existingMembershipCardType != null && !existingMembershipCardType.equals(aMembershipCardType))
    {
      existingMembershipCardType.removeSpecialPrice(this);
    }
    membershipCardType.addSpecialPrice(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Item placeholderItem = item;
    this.item = null;
    placeholderItem.removeSpecialPrice(this);
    MembershipCardType placeholderMembershipCardType = membershipCardType;
    this.membershipCardType = null;
    placeholderMembershipCardType.removeSpecialPrice(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "priceInCents" + ":" + getPriceInCents()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "item = "+(getItem()!=null?Integer.toHexString(System.identityHashCode(getItem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "membershipCardType = "+(getMembershipCardType()!=null?Integer.toHexString(System.identityHashCode(getMembershipCardType())):"null")
     + outputString;
  }
}