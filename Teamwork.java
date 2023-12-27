  
/**
 * Collaborative Pair Details:
 * - Yousef Moustafa UH ID: 21025449 [GitHub Username: @yousef-moustafa]
 * - Mohamed Helmy UH ID: 21019498 [GitHub Username: @mohamedhelmy21]
 * Description: We collaborated on a private GitHub repository, cloning it to our local desktops.
 * We used GitHub Desktop for version control, committing, pushing, and pulling changes.
 * Our workflow involved joint development and seamless synchronization via GitHub.
 */
public class Teamwork
{
    private String[] details = new String[6];
    
    public Teamwork()
    {   
        // In each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        // If there is only 1 team member, please complete details 
        // for programmer1
        
        details[0] = "Helmy";
        details[1] = "Mohamed";
        details[2] = "21019498";
        details[3] = "Moustafa";
        details[4] = "Yousef";
        details[5] = "21025449";
    }
    
    /**
     * Retrieves the team details.
     *
     * @return An array containing team member information.
     */
    public String[] getTeamDetails()
    {
        return details;
    }
    
    /**
     * Displays the team details.
     */
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
