/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-d60c319 modeling language!*/


import java.util.*;

// line 18 "model.ump"
// line 52 "model.ump"
public class Student extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Associations
  private List<Mentor> mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Student(String aName)
  {
    super(aName);
    mentors = new ArrayList<Mentor>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Mentor getMentor(int index)
  {
    Mentor aMentor = mentors.get(index);
    return aMentor;
  }

  public List<Mentor> getMentors()
  {
    List<Mentor> newMentors = Collections.unmodifiableList(mentors);
    return newMentors;
  }

  public int numberOfMentors()
  {
    int number = mentors.size();
    return number;
  }

  public boolean hasMentors()
  {
    boolean has = mentors.size() > 0;
    return has;
  }

  public int indexOfMentor(Mentor aMentor)
  {
    int index = mentors.indexOf(aMentor);
    return index;
  }

  public static int minimumNumberOfMentors()
  {
    return 0;
  }

  public static int maximumNumberOfMentors()
  {
    return 2;
  }

  public boolean addMentor(Mentor aMentor)
  {
    boolean wasAdded = false;
    if (mentors.contains(aMentor)) { return false; }
    if (numberOfMentors() >= maximumNumberOfMentors())
    {
      return wasAdded;
    }

    mentors.add(aMentor);
    if (aMentor.indexOfStudent(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMentor.addStudent(this);
      if (!wasAdded)
      {
        mentors.remove(aMentor);
      }
    }
    return wasAdded;
  }

  public boolean removeMentor(Mentor aMentor)
  {
    boolean wasRemoved = false;
    if (!mentors.contains(aMentor))
    {
      return wasRemoved;
    }

    int oldIndex = mentors.indexOf(aMentor);
    mentors.remove(oldIndex);
    if (aMentor.indexOfStudent(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMentor.removeStudent(this);
      if (!wasRemoved)
      {
        mentors.add(oldIndex,aMentor);
      }
    }
    return wasRemoved;
  }

  public boolean setMentors(Mentor... newMentors)
  {
    boolean wasSet = false;
    ArrayList<Mentor> verifiedMentors = new ArrayList<Mentor>();
    for (Mentor aMentor : newMentors)
    {
      if (verifiedMentors.contains(aMentor))
      {
        continue;
      }
      verifiedMentors.add(aMentor);
    }

    if (verifiedMentors.size() != newMentors.length || verifiedMentors.size() > maximumNumberOfMentors())
    {
      return wasSet;
    }

    ArrayList<Mentor> oldMentors = new ArrayList<Mentor>(mentors);
    mentors.clear();
    for (Mentor aNewMentor : verifiedMentors)
    {
      mentors.add(aNewMentor);
      if (oldMentors.contains(aNewMentor))
      {
        oldMentors.remove(aNewMentor);
      }
      else
      {
        aNewMentor.addStudent(this);
      }
    }

    for (Mentor anOldMentor : oldMentors)
    {
      anOldMentor.removeStudent(this);
    }
    wasSet = true;
    return wasSet;
  }

  public boolean addMentorAt(Mentor aMentor, int index)
  {  
    boolean wasAdded = false;
    if(addMentor(aMentor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMentors()) { index = numberOfMentors() - 1; }
      mentors.remove(aMentor);
      mentors.add(index, aMentor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMentorAt(Mentor aMentor, int index)
  {
    boolean wasAdded = false;
    if(mentors.contains(aMentor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMentors()) { index = numberOfMentors() - 1; }
      mentors.remove(aMentor);
      mentors.add(index, aMentor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMentorAt(aMentor, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Mentor> copyOfMentors = new ArrayList<Mentor>(mentors);
    mentors.clear();
    for(Mentor aMentor : copyOfMentors)
    {
      aMentor.removeStudent(this);
    }
    super.delete();
  }

}