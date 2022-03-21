package phonebook;

/**
 * API文档中的pattern类 有正则的文档
 */
public class RegexTest {

    public static void main(String[] args) {
//        String regex = "[^a]*";
//        String content = "cv";
//        System.out.println("content.matches(regex) = " + content.matches(regex));
//        String regex = "\\s+";
//        String content = "  ";
//          String regex = "[a-z]{1}\\w{3,8}";
////          String content = "a1_adad";
//            String regex = "(\\d{3,4})-([0-9]{7,8})";
//            String content = "00-14231242";
        String regex = "[mfMF]";
        String content = "M";
        System.out.println("content.matches(regex) = " + content.matches(regex));


    }
}
