package Controllers;

import Views.Menu;

public class MainController {
    private Menu menu = new Menu();
    private ServiceController serviceController;
    private CustomerController customerController;

    public MainController() {
        serviceController = new ServiceController();
        customerController = new CustomerController();
    }

    public void displayMainMenu() {
        int choice = menu.mainMenu();
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
                displayMainMenu();
            }
        }
    }

    private void showServices() {
        int choice = menu.showingServiceMenu();
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
            default: {
                System.exit(0);
            }
        }
    }


    private void addNewBooking() {
    }

    private void showInfoEmployee() {
    }

    private void addNewServices() {
        int choice = menu.addingServiceMenu();
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
            default: {
                System.exit(0);
            }
        }
    }

}
