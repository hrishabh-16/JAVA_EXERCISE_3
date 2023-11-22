import java.util.Scanner;

// Abstract class representing a general election candidate
abstract class Candidate 
{
    String name;
    int age;
    String address;
    int votes;

    // Constructor for initializing common data members
    Candidate(String name, int age, String address) 
    {
        this.name = name;
        this.age = age;
        this.address = address;
        this.votes = 0;
    }

    // Abstract method for campaigning
    abstract void campaign();

    // Method for casting a vote
    void vote() 
    {
        this.votes++;
        System.out.println(name + " received a vote!");
    }

    // Final method to display the candidate's votes
    final void displayVotes() {
        System.out.println(name + " has " + votes + " votes.");
    }
}

// Subclass demonstrating single-level inheritance
class PresidentialCandidate extends Candidate 
{
    String party;
    String area;
    String partySymbol;

    // Constructor for initializing additional data members
    PresidentialCandidate(String name, int age, String address, String party, String area, String partySymbol) 
    {
        super(name, age, address);
        this.party = party;
        this.area = area;
        this.partySymbol = partySymbol;
    }

    // Overridden method for campaigning with additional information
    @Override
    void campaign() 
    {
        System.out.println(name + " (" + age + " years old, from Address " + address + ") holding  party" + party + " is campaigning in "
                + area + " with party symbol: " + partySymbol);
    }
}

// Subclass demonstrating multilevel inheritance
class LocalCandidate extends PresidentialCandidate {
    String constituency;

    // Constructor for initializing additional data members
    LocalCandidate(String name, int age, String address, String party, String area, String partySymbol,
            String constituency) 
        {
        super(name, age, address, party, area, partySymbol);
        this.constituency = constituency;
        }

    // Overridden method for campaigning at both local and presidential levels
    @Override
    void campaign() 
    {
        super.campaign();
        System.out.println(name + " is a local candidate also campaigning in the " + constituency + " constituency.");
    }
}

// Subclass demonstrating hierarchical inheritance
class OppositionCandidate extends Candidate {
    // Constructor for initializing common data members
    OppositionCandidate(String name, int age, String address) 
    {
        super(name, age, address);
    }

    // Overridden method for campaigning against the ruling party
    @Override
    void campaign() {
        System.out.println(
                name + " (" + age + " years old, from address" + address + ") is campaigning against the ruling party.");
    }
}

// Main class for running the election system
public class ElectionSystem {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Taking user input for PresidentialCandidate
        System.out.println("Enter details for Presidential Candidate:");
        System.out.print("Name: ");
        String presidentialName = sc.nextLine();
        System.out.print("Age: ");
        int presidentialAge = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Address: ");
        String presidentialAddress = sc.nextLine();
        System.out.print("Party: ");
        String presidentialParty = sc.nextLine();
        System.out.print("Area: ");
        String presidentialArea = sc.nextLine();
        System.out.print("Party Symbol: ");
        String presidentialPartySymbol = sc.nextLine();

        // Creating an instance of PresidentialCandidate with user input
        PresidentialCandidate presidentialCandidate = new PresidentialCandidate(
                presidentialName, presidentialAge, presidentialAddress,
                presidentialParty, presidentialArea, presidentialPartySymbol);

        // Taking user input for LocalCandidate
        System.out.println("\nEnter details for Local Candidate:");
        System.out.print("Name: ");
        String localName = sc.nextLine();
        System.out.print("Age: ");
        int localAge = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Address: ");
        String localAddress = sc.nextLine();
        System.out.print("Party: ");
        String localParty = sc.nextLine();
        System.out.print("Area: ");
        String localArea = sc.nextLine();
        System.out.print("Party Symbol: ");
        String localPartySymbol = sc.nextLine();
        System.out.print("Constituency: ");
        String localConstituency = sc.nextLine();

        // Creating an instance of LocalCandidate with user input
        LocalCandidate localCandidate = new LocalCandidate(
                localName, localAge, localAddress,
                localParty, localArea, localPartySymbol, localConstituency);

        // Taking user input for OppositionCandidate
        System.out.println("\nEnter details for Opposition Candidate:");
        System.out.print("Name: ");
        String oppositionName = sc.nextLine();
        System.out.print("Age: ");
        int oppositionAge = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Address: ");
        String oppositionAddress = sc.nextLine();

        // Creating an instance of OppositionCandidate with user input
        OppositionCandidate oppositionCandidate = new OppositionCandidate(
                oppositionName, oppositionAge, oppositionAddress);

        // Close the scanner to prevent resource leaks
        sc.close();

        // Campaigning, voting, and displaying votes for each candidate
        System.out.println("\nElection Campaign and Voting Results:\n");
        presidentialCandidate.campaign();
        presidentialCandidate.vote();
        presidentialCandidate.displayVotes();

        localCandidate.campaign();
        localCandidate.vote();
        localCandidate.displayVotes();

        oppositionCandidate.campaign();
        oppositionCandidate.vote();
        oppositionCandidate.displayVotes();
    }
}
