import java.util.Arrays;
import java.util.Scanner;

public class demo_001 {
	   /*��ʼ���û����ݣ��û��������䣬״̬��
	    * ������main����������������������
	      Ҫ�ĳɾ�̬�ģ�main�����Ǿ�̬�ģ����涨����൱�ڳ�Ա������
	      Ҫ��Ȼ�޷�����*/
	   static String[] names = {"����","����","����","С��"};
	   static int[] ages = {22,23,20,22};
	   static String[] states = {"����","����","����","����"};
	public static void main(String[] args) {
		/*������һ��ϸ��ע�����scanner���󴴽����ܷ���ѭ���
		 �������ѭ������ζ��ÿѭ��һ�ξͻᴴ��һ������������ɿռ���˷ѣ�
		����ֻ��Ҫһ��scanner����Ϳ����ˣ����Է���ѭ�����������*/
		Scanner scanner = new Scanner(System.in);
		int num;
		do {
			System.out.println("------��ӭʹ���û�����ϵͳ------");
			System.out.println("1.��ѯ�û�");
			System.out.println("2.����û�");
			System.out.println("3.ɾ���û�");
			System.out.println("4.�˺Ŷ���");
			System.out.println("5.�˺Žⶳ");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("��ѡ��");
			num = scanner.nextInt();
			switch(num) {
			case 1:
				//System.out.println("ִ�в�ѯ�û�����");
				System.out.println("-------��ѯ�û�------");
				System.out.println("���\t\t����\t\t����\t\t״̬");
				//�����������飬���ȶ�һ��
				for(int i=0;i<names.length;i++) {
					if(names[i] !=null) {
						// \t��һ���Ʊ��������һ��table
						System.out.println((i+1)+"\t\t"+names[i]+"\t\t"+ages[i]+"\t\t"+states[i]);
					}
				}
				System.out.println("����0�����ϼ��˵�");
				num  = scanner.nextInt();
			break;
			case 2:
				//System.out.println("ִ������û�����");
				System.out.println("-------����û�------");
                //ʵ�ֶ�̬����
				System.out.println("�������û�������");
                String name = scanner.next();
                if(nameIsExist(name)) {
                	System.out.println(name+"�Ѵ���,�����ظ���ӣ�");
                }else {
                	if(names[names.length-1]!=null) {
                    	//�����µ����飬���ҽ��������ֵ����������
                    	names = Arrays.copyOf(names, names.length+1);
                    	names[names.length-1] = name;
                    	System.out.println("������"+name+"������");
                    	int age = scanner.nextInt();
                    	ages = Arrays.copyOf(ages, ages.length+1);
                    	ages[ages.length-1] = age;
                    	states = Arrays.copyOf(states, states.length+1);
                    	states[states.length-1] = "����";
                    }
                    else {
                    	int index = getFirstNull();
                    	names[index] = name;
                    	System.out.println("������"+name+"������");
                    	int age = scanner.nextInt();
                    	ages[index] = age;
                    	states[index] = "����";
                    }
                	
                }
                
//			    if(names[names.length-1]!=null) {
//		    	System.out.println("�����Ѿ����������û��޷�����");
//			    }else {
//			    	System.out.println("�������û�����");
//			    	String name = scanner.next();
//			    	boolean flag = nameIsExist(name);
//			    	if(flag) {
//			    		System.out.println(name+"�Ѵ��ڣ������ظ����");
//			    	}else {
//			    		names[names.length-1] = name;
//			    		System.out.println("������"+name+"������");
//			    		int age = scanner.nextInt();
//			    		ages[ages.length-1] = age;
//			    		states[states.length-1]= "����";
//			    		System.out.println(name+"��ӳɹ�");
//			    	}
//			    }
			    System.out.println("����0�����ϼ��˵�");
			    num = scanner.nextInt();
			break;
			case 3:
				//System.out.println("ִ��ɾ���û�����");
				System.out.println("-------ɾ���û�------");
				if(names[0] == null) {
			    	System.out.println("�û��Ѿ�ȫ��ɾ����");
			    }else {
			    	System.out.println("�������û���");
			    	name = scanner.next();
			    	if(nameIsExist(name)) {
			    		int index = getIndex(name);
			    		if(index>=0) {
			    			for(int i=index;i<names.length-1;i++) {
			    				names[i] = names[i+1];
			    				ages[i] = ages[i+1];
			    				states[i] = states[i+1];
			    			}
			    			//���������һλ��Ϊ��
			    			names[names.length-1] = null;
			    			ages[ages.length-1] = 0;
			    			states[states.length-1] = null;
			    		}
			    	}else {
			    		System.out.println("��������û������ڣ�");
			    	}
			    }
				System.out.println("����0�����ϼ��˵�");
			    num = scanner.nextInt();
			break;
			case 4:
				//System.out.println("ִ���˺Ŷ������");
				System.out.println("-------�˺Ŷ���------");
				System.out.println("�������û�����");
				name = scanner.next();
				if(nameIsExist(name)) {
					int index =  getIndex(name);
					String state = states[index];
					if(state.equals("����")) {
						System.out.println(name+"�˺��Ѿ������ᣬ�����ظ�������");
					}else {
						states[index] = "����";
						System.out.println(name+"����ɹ�");
					}
				}else {
					System.out.println("��������û������ڣ�");
				}
				System.out.println("����0�����ϼ��˵�");
			    num = scanner.nextInt();
			break;
			case 5:
				//System.out.println("ִ���˺Žⶳ����");
				System.out.println("-------�˺Žⶳ------");
				System.out.println("�������û�����");
				name = scanner.next();
				if(nameIsExist(name)) {
					int index = getIndex(name);
					String state = states[index];
					if(state.equals("����")) {
						System.out.println(name+"�ѽⶳ�������ظ�������");
					}else {
						states[index] = "����";
						System.out.println(name+"�ɹ��ⶳ");
					}
				}else {
					System.out.println(name+"�����ڣ����������룡");
				}
				System.out.println("����0�����ϼ��˵�");
			    num = scanner.nextInt();
			break;
			case 6:
				System.out.println("��лʹ�ñ�ϵͳ���ټ���");
			break;
			default:
			break;
			}
			
		}while(num<6);//while(num==0);Ҳ����
	}
	/**
	 * �ж��û�����������Ƿ��Ѿ�������������
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
	 * �ҵ������������е��±�
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
	 * �ҵ������е�һ��Ϊ�յ��±�
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
