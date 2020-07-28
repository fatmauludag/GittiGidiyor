import org.junit.Test;

public class Login extends BaseTest {

    @Test
    public void doTest() throws InterruptedException {
        getUrl("https://www.gittigidiyor.com/uye-girisi");
        setById("L-UserNameField", "taskmailim2020@gmail.com");
        setById("L-PasswordField", "tasksifre2020");
        clickById("gg-login-enter");
        Thread.sleep(4000);
        wait.until(documentReady);
    }
}
