package phonebook;

import java.util.Scanner;

/**
 * 数据校验类
 */
public class TelNoteRegex {
    /**
     * 对菜单输入选项的验证
     * @param min
     * @param max
     */
    public int menuItemValidate(int min, int max){
        //定义验证菜单项的正则表达式
        String regex = "[1-9]{1}";
        Scanner scanner  = new Scanner(System.in);

        while(true){
            System.out.println("请输入正确的数字，最小是："+min+"\t"+"最大是："+max);
            String input = scanner.nextLine();
            if(input.matches(regex)){
                int inputNum = Integer.parseInt(input);
                if(inputNum >= min && inputNum <= max){
                    return inputNum;
                }else {
                    System.out.println("您输入的菜单项不符，请重新输入！");
                }
            }else{
                System.out.println("输入数字错误，请检查！");
            }
        }
    }

    /**
     * 对姓名验证
     *
     * @return
     */
    public String nameValidate(){
        String regex = "[a-zA-Z]{1,10}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入姓名，格式为：1-10之间的大写或小写字母：");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("您当前输入的姓名有误，请重新输入：");
            }
        }
    }

    /**
     * 对年龄验证
     * @return
     */
    public String  ageValidate(){
        String regex = "[1-9]{1}[0-9]{1}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入年龄，范围是10-99：");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else {
                System.out.println("您当前输入的年龄有误，请重新输入：");
            }
        }
    }

    /**
     * 男 m M 女 f F
     * @return
     */
    public String sexValidate(){
        String regex = "[mMfF]";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入性别：男Mm,女Nn:");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("您当前输入的性别有误，请重新输入：");
            }
        }
    }

    /**
     * 电话号码要求
     * 允许带有区号的座机号和手机号
     * @return
     */
    public String telNumValidate(){
        String regex = "(\\d{3,4}-\\d{7,8})|([1]{1}\\d{10})";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入电话号码：可以是座机号或者是手机号");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("输入的号码有误，请重新输入：");
            }
        }
    }

    /**
     * 验证地址
     * @return
     */
    public String addValidate(){
        String regex = "\\w{1,50}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入地址：格式为字母或数字，长度为1-50");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("输入错误，请重新输入：");
            }
        }
    }

//    public static void main(String[] args) {
//        TelNoteRegex regex = new TelNoteRegex();
////        int menuItem = regex.menuItemValidate(1,6);
////        System.out.println(menuItem);
////
////        String name = regex.nameValidate();
////        System.out.println(name);
//        String age = regex.ageValidate();
//        System.out.println(age);
//
//    }
}
