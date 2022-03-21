package phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 核心业务类
 */
public class Operate {
    private List<Person> list;
    public Operate(){
        this.list = new ArrayList<>();
    }

    /**
     * 用户添加记录的 业务逻辑控制
     */
    public void addLogic(){
        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while(true){
            menu.addMenu();
            int item = telNoteRegex.menuItemValidate(1,3);
            switch(item){
                case 1:addOperation();break;
                case 2:showAll();break;
                case 3:return; //结束当前方法


            }

        }
    }
    /**
     * 用户查询记录的 业务逻辑控制
     */
    public void searchLogic(){
        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while(true){
            menu.searchMenu();
            int item = telNoteRegex.menuItemValidate(1,7);
            switch(item){
                case 1:searchByName();break;
                case 2:searchByAge();break;
                case 3:searchBySex();break;
                case 4:searchByTelNum();break;
                case 5:searchByAdd();break;
                case 6:showAll();break;
                case 7: return;
            }
        }
    }
    /**
     * 用户修改记录的 业务逻辑控制
     */
    public void modifyLogic(){
        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while(true){
            menu.modifyMenu();
            int item = telNoteRegex.menuItemValidate(1,3);
            switch (item){
                case 1:showAll();break;
                case 2:modifyOperation();break;
                case 3:return;
            }
        }
    }
    /**
     * 用户删除记录的 业务逻辑控制
     */
    public void deleteLogic(){
        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while(true){
            menu.deleteMenu();
            int item = telNoteRegex.menuItemValidate(1,4);
            switch (item){
                case 1:showAll();break;
                case 2:deleteOperation();break;
                case 3:deleteAllOperation();break;
                case 4:return;
            }
        }
    }
    public void orderLogic(){
        Menu menu = new Menu();
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        while(true){
            menu.orderMenu();
            int item = telNoteRegex.menuItemValidate(1,5);
            switch (item){
                case 1:orderName();break;
                case 2:orderAge();break;
                case 3:orderSex();break;
                case 4:showAll();break;
                case 5:return;
            }
        }
    }

    /**
     * 添加新纪录
     */
    public void addOperation(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String name = telNoteRegex.nameValidate();
        String age = telNoteRegex.ageValidate();
        String sex = telNoteRegex.sexValidate();
        String telNum = telNoteRegex.telNumValidate();
        String address = telNoteRegex.addValidate();
        Person person = new Person(name,age,sex,telNum,address);
        list.add(person);
        person.setId(list.size());
    }
    /**
     * 查询全部记录
     */
    public void showAll(){
        if(list.size() == 0) {
            System.out.println("没有任何记录");
            return;
        }
        for(Person p:list){
            System.out.println(p);
        }
    }
    /**
     * 按姓名查找
     */
    public void searchByName(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String name =  telNoteRegex.nameValidate();
        boolean flag = true;
        for (int i = 0; i < list.size() ; i++) {
            if(name.equals(list.get(i).getName())){
                System.out.println(list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("没有此人记录");
        }

    }
    /**
     * 按年龄查找
     */
    public void searchByAge(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String age =  telNoteRegex.ageValidate();
        boolean flag = true;
        for (int i = 0; i < list.size() ; i++) {
            if(age.equals(list.get(i).getAge())){
                System.out.println(list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("没有此人记录");
        }


    }
    /**
     * 按性别查找
     */
    public void searchBySex(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String sex =  telNoteRegex.sexValidate();
        boolean flag = true;
        for (int i = 0; i < list.size() ; i++) {
            //忽略大小写
            if(sex.equalsIgnoreCase(list.get(i).getSex())){
                System.out.println(list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("没有此人记录");
        }
    }
    /**
     * 按电话号码查找
     */
    public void searchByTelNum(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String telNum =  telNoteRegex.telNumValidate();
        boolean flag = true;
        for (int i = 0; i < list.size() ; i++) {
            if(telNum.equals(list.get(i).getTelNum())){
                System.out.println(list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("没有此人记录");
        }

    }

    /**
     * 按地址查找
     */
    public void searchByAdd(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        String address =  telNoteRegex.addValidate();
        boolean flag = true;
        for (int i = 0; i < list.size() ; i++) {
            if(address.equals(list.get(i).getAddress())){
                System.out.println(list.get(i));
                flag = false;
            }
        }
        if(flag){
            System.out.println("没有此人记录");
        }

    }
    /**
     * 修改指定记录
     */
    public void modifyOperation(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        Menu menu = new Menu();
        //对序号验证
        int item = telNoteRegex.menuItemValidate(1,list.size());
        System.out.println("请输入记录的序号");

        menu.subModifyMenu();
        int menuItem = telNoteRegex.menuItemValidate(1,6);
        switch(menuItem){
            case 1:
                String name = telNoteRegex.nameValidate();
                list.get(item-1).setName(name);
                break;
            case 2:
                String age = telNoteRegex.ageValidate();
                list.get(item-1).setAge(age);
                break;
            case 3:
                String sex = telNoteRegex.sexValidate();
                list.get(item-1).setSex(sex);
                break;
            case 4:
                String telNum = telNoteRegex.telNumValidate();
                list.get(item-1).setTelNum(telNum);
                break;
            case 5:
                String address = telNoteRegex.addValidate();
                list.get(item-1).setAddress(address);
                break;
            case 6:return;

        }

    }
    /**
     * 删除指定记录
     */
    public void deleteOperation(){
        TelNoteRegex telNoteRegex = new TelNoteRegex();
        System.out.println("请输入记录的序号：");
        int item = telNoteRegex.menuItemValidate(1,list.size());
        list.remove(item-1);
        //重新设置新的序号
        for (int i = 0; i < list.size() ; i++) {
            list.get(i).setId(i+1);
        }
        System.out.println("删除成功");
    }
    /**
     * 删除全部记录
     */
    public void deleteAllOperation(){
        list.clear();
        System.out.println("电话中的记录已清空，请继续操作：");
    }
    /**
     * 按用户姓名排序记录
     */
    public void orderName(){
        //   排序list,    比较器
        Collections.sort(list,new OrderByName());
        //重新设置序号
        for (int i = 0; i < list.size() ; i++) {
            list.get(i).setId(i+1);
            System.out.println(list.get(i));
        }

    }
    /**
     * 按姓名排序的比较器
     */
    class OrderByName implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    /**
     * 按用户年龄排序记录
     */
    public void orderAge(){
        Collections.sort(list,new OrderByAge());
        for (int i = 0; i < list.size() ; i++) {
            list.get(i).setId(i+1);
            System.out.println(list.get(i));
        }
    }
    /**
     * 按年龄排序的比较器
     */
    class OrderByAge implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    }

    /**
     * 按用户性别排序记录
     */
    public void orderSex(){
        Collections.sort(list,new OrderBySex());
        for (int i = 0; i < list.size() ; i++) {
            list.get(i).setId(i+1);
            System.out.println(list.get(i));
        }
    }
    /**
     * 按性别排序的比较器
     */
    class OrderBySex implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getSex().compareTo(o2.getSex());
        }
    }

}
