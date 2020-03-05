package Controllers;

import Commons.ReadWriteCSV;
import Models.*;
import Views.Menu;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private Menu menu = new Menu();
    private ServiceController serviceController;
    private CustomerController customerController;
    private Scanner scanner;
    private ReadWriteCSV readWriteCSV;

    public MainController() {
        serviceController = new ServiceController();
        customerController = new CustomerController();
        readWriteCSV = new ReadWriteCSV();
        scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        int choice = menu.displayMainMenu();
        switch (choice) {
            case 1: {
                addNewServices();
                break;
            }
            case 2: {
                showServices();
                break;
            }
            case 3: {
                customerController.addNewCustomers();
                displayMainMenu();
                break;
            }
            case 4: {
                customerController.showInfoCustomer();
                displayMainMenu();
                break;
            }
            case 5: {
                addNewBooking();
                break;
            }
            case 6: {
                showInfoEmployee();
                break;
            }
            case 7: {
                System.exit(0);
            }
            default: {
                System.out.println("Your choice is not found.");
                displayMainMenu();
            }
        }
    }

    private void showServices() {
        int choice = menu.displayShowingServiceMenu();
        switch (choice) {
            case 1: {
                serviceController.showVillaService();
                showServices();
                break;
            }
            case 2: {
                serviceController.showHouseService();
                showServices();
                break;
            }
            case 3: {
                serviceController.showRoomService();
                showServices();
                break;
            }
            case 4: {
                serviceController.showAllNameVillaNotDuplicate();
                showServices();
                break;
            }
            case 5: {
                serviceController.showAllNameHouseNotDuplicate();
                showServices();
                break;
            }
            case 6: {
                serviceController.showAllNameRoomNotDuplicate();
                showServices();
                break;
            }

            case 7: {
                displayMainMenu();
                break;
            }
            case 8: {
                System.exit(0);
            }
            default: {
                System.out.println("Your choice is not found.");
                showServices();
            }
        }
    }


    private void addNewBooking() {
        List<Customer> listCustomers = customerController.getCustomers();
        int choice;
        System.out.println("Choose the customer: ");
        for (Customer customer : listCustomers) {
            System.out.println(listCustomers.indexOf(customer) + ": " + customer.getNameCustomer());
        }
        choice = scanner.nextInt();
        Customer selectedCustomer = null;
        if (choice >= listCustomers.size()) {
            System.out.println("out of size.");
            addNewBooking();
        } else {
            selectedCustomer = listCustomers.get(choice);
        }
        choice = menu.displayBookingMenu();
        Service selectedService = null;
        switch (choice) {
            case 1:
                List<Villa> villas = serviceController.getVillas();
                if (villas.size() == 0) {
                    System.out.println("List villa is empty.");
                    addNewBooking();
                }
                for (Villa villa : villas) {
                    System.out.println(villas.indexOf(villa) + ": " + villa.getServiceName());
                }
                choice = scanner.nextInt();
                if (choice > villas.size()) {
                    System.out.println("out of size.");
                    addNewBooking();
                } else {
                    selectedService = villas.get(choice);
                }
                break;
            case 2:
                List<House> houses = serviceController.getHouses();
                if (houses.size() == 0) {
                    System.out.println("List house is empty.");
                    addNewBooking();
                }
                for (House house : houses) {
                    System.out.println(houses.indexOf(house) + ": " + house.getServiceName());
                }
                choice = scanner.nextInt();
                if (choice > houses.size()) {
                    System.out.println("out of size.");
                    addNewBooking();
                } else {
                    selectedService = houses.get(choice);
                }
                break;
            case 3:
                List<Room> rooms = serviceController.getRooms();
                if (rooms.size() == 0) {
                    System.out.println("List room is empty.");
                    addNewBooking();
                }
                for (Room room : rooms) {
                    System.out.println(rooms.indexOf(room) + ": " + room.getServiceName());
                }
                choice = scanner.nextInt();
                if (choice > rooms.size()) {
                    System.out.println("out of size.");
                    addNewBooking();
                } else {
                    selectedService = rooms.get(choice);
                }
                break;
            default:
                System.out.println("There is not this option.");
        }
        assert selectedCustomer != null;
        List<Booking> bookings = readWriteCSV.readFileBookingCSV();
        Booking newBooking = new Booking();
        newBooking.setIdCustomer(selectedCustomer.getId());
        newBooking.setCustomerName(selectedCustomer.getNameCustomer());
        newBooking.setIdService(selectedService.getId());
        newBooking.setServiceName(selectedService.getServiceName());
        bookings.add(newBooking);
        readWriteCSV.writeBookingToCSVFile(bookings);
        displayMainMenu();
    }

    private void showInfoEmployee() {
    }

    private void addNewServices() {
        int choice = menu.displayAddingServiceMenu();
        switch (choice) {
            case 1: {
                serviceController.addListVillaService();
                addNewServices();
                break;
            }
            case 2: {
                serviceController.addListHouseService();
                addNewServices();
                break;
            }
            case 3: {
                serviceController.addListRoomService();
                addNewServices();
                break;
            }

            case 4: {
                displayMainMenu();
                break;
            }
            case 5: {
                System.exit(0);
            }
            default: {
                System.out.println("Your choice is not found.");
                addNewServices();
            }
        }
    }

}
