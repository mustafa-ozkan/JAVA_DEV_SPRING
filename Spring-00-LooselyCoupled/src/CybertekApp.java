import com.cybertek.services.FullTimeMentor;
import com.cybertek.services.MentorAccount;
import com.cybertek.services.PartTimeMentor;

public class CybertekApp {

    public static void main(String[] args) {
        FullTimeMentor fullTimeMentor = new FullTimeMentor();
        PartTimeMentor partTimeMentor = new PartTimeMentor();

        MentorAccount mentor = new MentorAccount(fullTimeMentor);
        mentor.manageAccount();

    }

}
