import java.util.Arrays;
import java.util.Scanner;

public class demo_001 {
	   /*初始化用户数据（用户名，年龄，状态）
	    * 定义在main方法外来扩大数组作用域
	      要改成静态的，main方法是静态的，外面定义的相当于成员变量，
	      要不然无法访问*/
	   static String[] names = {"张三","李四","王五","小明"};
	   static int[] ages = {22,23,20,22};
	   static String[] states = {"正常","正常","正常","正常"};
	public static void main(String[] args) {
		/*这里有一个细节注意的是scanner对象创建不能放在循坏里，
		 如果放在循环里意味着每循环一次就会创建一个，这样会造成空间的浪费，
		我们只需要一个scanner对象就可以了，所以放在循环体外面就行*/
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.println("------欢迎使用用户管理系统------");
			System.out.println("1.查询用户");
			System.out.println("2.添加用户");
			System.out.println("3.删除用户");
			System.out.println("4.账号冻结");
			System.out.println("5.账号解冻");
			System.out.println("6.退出系统");
			System.out.println("请选择：");
			num = scanner.nextInt();
			switch(num) {
			case 1:
				//System.out.println("执行查询用户操作");
				System.out.println("-------查询用户------");
				System.out.println("编号\t\t姓名\t\t年龄\t\t状态");
				//遍历三个数组，长度都一样
				for(int i=0;i<names.length;i++) {
					if(names[i] !=null) {
						// \t是一个制表符，等于一个table
						System.out.println((i+1)+"\t\t"+names[i]+"\t\t"+ages[i]+"\t\t"+states[i]);
					}
				}
				System.out.println("输入0返回上级菜单");
				num  = scanner.nextInt();
			break;
			case 2:
				//System.out.println("执行添加用户操作");
				System.out.println("-------添加用户------");
                //实现动态扩充
				System.out.println("请输入用户姓名：");
                String name = scanner.next();
                if(nameIsExist(name)) {
                	System.out.println(name+"已存在,请勿重复添加！");
                }else {
                	if(names[names.length-1]!=null) {
                    	//创建新的数组，并且将老数组的值存入新数组
                    	names = Arrays.copyOf(names, names.length+1);
                    	names[names.length-1] = name;
                    	System.out.println("请输入"+name+"的年龄");
                    	int age = scanner.nextInt();
                    	ages = Arrays.copyOf(ages, ages.length+1);
                    	ages[ages.length-1] = age;
                    	states = Arrays.copyOf(states, states.length+1);
                    	states[states.length-1] = "正常";
                    }
                    else {
                    	int index = getFirstNull();
                    	names[index] = name;
                    	System.out.println("请输入"+name+"的年龄");
                    	int age = scanner.nextInt();
                    	ages[index] = age;
                    	states[index] = "正常";
                    }
                	
                }
                
//			    if(names[names.length-1]!=null) {
//		    	System.out.println("数组已经填满，新用户无法加入");
//			    }else {
//			    	System.out.println("请输入用户姓名");
//			    	String name = scanner.next();
//			    	boolean flag = nameIsExist(name);
//			    	if(flag) {
//			    		System.out.println(name+"已存在，请勿重复添加");
//			    	}else {
//			    		names[names.length-1] = name;
//			    		System.out.println("请输入"+name+"的年龄");
//			    		int age = scanner.nextInt();
//			    		ages[ages.length-1] = age;
//			    		states[states.length-1]= "正常";
//			    		System.out.println(name+"添加成功");
//			    	}
//			    }
			    System.out.println("输入0返回上级菜单");
			    num = scanner.nextInt();
			break;
			case 3:
				//System.out.println("执行删除用户操作");
				System.out.println("-------删除用户------");
				if(names[0] == null) {
			    	System.out.println("用户已经全部删除！");
			    }else {
			    	System.out.println("请输入用户名");
			    	name = scanner.next();
			    	if(nameIsExist(name)) {
			    		int index = getIndex(name);
			    		if(index>=0) {
			    			for(int i=index;i<names.length-1;i++) {
			    				names[i] = names[i+1];
			    				ages[i] = ages[i+1];
			    				states[i] = states[i+1];
			    			}
			    			//把数组最后一位置为空
			    			names[names.length-1] = null;
			    			ages[ages.length-1] = 0;
			    			states[states.length-1] = null;
			    		}
			    	}else {
			    		System.out.println("您输入的用户不存在！");
			    	}
			    }
				System.out.println("输入0返回上级菜单");
			    num = scanner.nextInt();
			break;
			case 4:
				//System.out.println("执行账号冻结操作");
				System.out.println("-------账号冻结------");
				System.out.println("请输入用户名：");
				name = scanner.next();
				if(nameIsExist(name)) {
					int index =  getIndex(name);
					String state = states[index];
					if(state.equals("冻结")) {
						System.out.println(name+"账号已经被冻结，请勿重复操作！");
					}else {
						states[index] = "冻结";
						System.out.println(name+"冻结成功");
					}
				}else {
					System.out.println("您输入的用户不存在！");
				}
				System.out.println("输入0返回上级菜单");
			    num = scanner.nextInt();
			break;
			case 5:
				//System.out.println("执行账号解冻操作");
				System.out.println("-------账号解冻------");
				System.out.println("请输入用户名：");
				name = scanner.next();
				if(nameIsExist(name)) {
					int index = getIndex(name);
					String state = states[index];
					if(state.equals("正常")) {
						System.out.println(name+"已解冻，请勿重复操作！");
					}else {
						states[index] = "正常";
						System.out.println(name+"成功解冻");
					}
				}else {
					System.out.println(name+"不存在，请重新输入！");
				}
				System.out.println("输入0返回上级菜单");
			    num = scanner.nextInt();
			break;
			case 6:
				System.out.println("感谢使用本系统，再见！");
			break;
			default:
			break;
			}
			
		}while(num<6);//while(num==0);也可以
	}
	/**
	 * 判断用户输入的姓名是否已经存在与数组中
	 */
	public static boolean nameIsExist(String name) {
		for(int i=0;i<names.length;i++) {
			if(name.equals(names[i])) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 找到名字在数组中的下标
	 */
	public static int getIndex(String name) {
		for(int i=0;i<names.length;i++) {
			if(name.equals(names[i])) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 找到数组中第一个为空的下标
	 */
	public static int getFirstNull() {
		for(int i=0;i<names.length;i++) {
			if(names[i] == null) {
				return i;
			}
		}
		return -1;
	}

}
