package case_study.service.control;

import case_study.models.Person.Customer;
import case_study.models.Person.Employee;
import case_study.service.IService.ICustomerService;
import case_study.util.ReadandWrite;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE_CUSTOMER = "src/case_study/data/Customer.csv";
    static private List<Customer> customerList;

    static {
        customerList = new LinkedList<>();
    }

    @Override
    public void display() {
        ReadandWrite.readFileList(PATH_FILE_CUSTOMER);
        for (Customer customer : customerList) {
            System.out.printf(customer.toString());
        }
    }

    @Override
    public void add() {
        System.out.printf("Nhập thông tin theo yêu cầu");
        System.out.println("\nNhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập số tuổi");
        String birthday = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String sex = scanner.nextLine();
        System.out.println("Nhập chứng minh");
        String idCard = scanner.nextLine();
        System.out.println("Nhập phone");
        String phone = scanner.nextLine();
        System.out.println("Nhập Email");
        String email = scanner.nextLine();
        System.out.println("Nhập loại khách hàng");
        String customerType = scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng");
        String address = scanner.nextLine();
        int id = customerList.size() + 1;
        Customer customer = new Customer(id, name, birthday, sex, idCard, phone, email, customerType, address);
        customerList.add(customer);
        ReadandWrite.writeAndReadList(customerList, PATH_FILE_CUSTOMER, false);
        System.out.println("Đã thêm thành công");

    }

    @Override
    public void edit() {
        int checkId = 0;
        System.out.println("Nhập id muốn sửa: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == inputId) {
                System.out.println("\nNhập tên");
                String name = scanner.nextLine();
                System.out.println("Nhập số tuổi");
                String birthday = scanner.nextLine();
                System.out.println("Nhập giới tính");
                String sex = scanner.nextLine();
                System.out.println("Nhập chứng minh");
                String idCard = scanner.nextLine();
                System.out.println("Nhập phone");
                String phone = scanner.nextLine();
                System.out.println("Nhập Email");
                String email = scanner.nextLine();
                System.out.println("Nhập loại khách hàng");
                String customerType = scanner.nextLine();
                System.out.println("Nhập địa chỉ khách hàng");
                String address = scanner.nextLine();


                customerList.get(i).setName(name);
                customerList.get(i).setBirthday(birthday);
                customerList.get(i).setSex(sex);
                customerList.get(i).setIdCard(idCard);
                customerList.get(i).setPhone(phone);
                customerList.get(i).setEmail(email);
                customerList.get(i).setCustomerType(customerType);
                customerList.get(i).setAddress(address);

                System.out.println("Cập nhập thành công");
                checkId++;
            }
        }
        if (checkId == 0) {
            System.out.println("Không tìm thấy id");
        }
    }
}