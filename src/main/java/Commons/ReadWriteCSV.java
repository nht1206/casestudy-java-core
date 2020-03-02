package Commons;

import Models.House;
import Models.Room;
import Models.Villa;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadWriteCSV {
    CSVWriter writer = null;
    private final char COMMA_DELIMITER = ',';
    private final char DEFAULT_QUOTE = '"';
    private final String NEW_LINE_SEPARATOR = "\n";
    private final int NUM_OF_LINE_SKIP = 1;
    private final String PATH_FILE_VILLA = "src/main/java/Data/Villa.csv";
    private final String PATH_FILE_HOUSE = "src/main/java/Data/House.csv";
    private final String PATH_FILE_ROOM = "src/main/java/Data/Room.csv";
    private final String PATH_FILE_CUSTOMER = "src/main/java/Customer.csv";
    private final String[] FILE_HEADER_OF_VILLA = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "roomStandard", "descriptionOfAmenities", "areaOfPool", "numberOfFloors"};
    private final String[] FILE_HEADER_OF_HOUSE = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "roomStandard", "descriptionOfAmenities", "numberOfFloors"};
    private final String[] FILE_HEADER_OF_ROOM = {"id", "serviceName", "usableArea", "rentalCosts", "maxNumberOfPeople", "typeOfRent", "freeServiceAccompany"};
    private final String[] FILE_HEADER_OF_CUSTOMER = {" id", " nameCustomer", "idCard", " birthday", " gender", " phoneNumber", " email", " typeCustomer", " address"};

    public void writeVillaToCSVFile(List<Villa> listVillas) {
        try {
            writer = new CSVWriter(new FileWriter(PATH_FILE_VILLA), COMMA_DELIMITER, DEFAULT_QUOTE, NEW_LINE_SEPARATOR);
            writer.writeNext(FILE_HEADER_OF_VILLA);
            List<String[]> allData = new ArrayList<String[]>();
            for (Villa villa : listVillas) {
                String[] data = new String[]{
                        villa.getId() + "",
                        villa.getServiceName() + "",
                        villa.getUsableArea() + "",
                        villa.getRentalCosts() + "",
                        villa.getMaxNumberOfPeople() + "",
                        villa.getTypeOfRent() + "",
                        villa.getRoomStandard() + "",
                        villa.getDescriptionOfAmenities() + "",
                        villa.getAreaOfPool() + "",
                        villa.getNumberOfFloors() + ""
                };
                allData.add(data);
            }
            writer.writeAll(allData);

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing CSVWriter !!!");
                e.printStackTrace();
            }
        }
    }
    public void writeHouseToCSVFile(List<House> listHouses) {
        try {
            writer = new CSVWriter(new FileWriter(PATH_FILE_HOUSE), COMMA_DELIMITER, DEFAULT_QUOTE, NEW_LINE_SEPARATOR);
            writer.writeNext(FILE_HEADER_OF_HOUSE);
            List<String[]> allData = new ArrayList<String[]>();
            for (House house : listHouses) {
                String[] data = new String[]{
                        house.getId() + "",
                        house.getServiceName() + "",
                        house.getUsableArea() + "",
                        house.getRentalCosts() + "",
                        house.getMaxNumberOfPeople() + "",
                        house.getTypeOfRent() + "",
                        house.getRoomStandard() + "",
                        house.getDescriptionOfAmenities() + "",
                        house.getNumberOfFloors() + ""
                };
                allData.add(data);
            }
            writer.writeAll(allData);

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing CSVWriter !!!");
                e.printStackTrace();
            }
        }
    }
    public void writeRoomToCSVFile(List<Room> listRooms) {
        try {
            writer = new CSVWriter(new FileWriter(PATH_FILE_ROOM), COMMA_DELIMITER, DEFAULT_QUOTE, NEW_LINE_SEPARATOR);
            writer.writeNext(FILE_HEADER_OF_ROOM);
            List<String[]> allData = new ArrayList<String[]>();
            for (Room room : listRooms) {
                String[] data = new String[]{
                        room.getId() + "",
                        room.getServiceName() + "",
                        room.getUsableArea() + "",
                        room.getRentalCosts() + "",
                        room.getMaxNumberOfPeople() + "",
                        room.getTypeOfRent() + "",
                        room.getFreeServiceAccompany() + ""
                };
                allData.add(data);
            }
            writer.writeAll(allData);

        } catch (IOException e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing CSVWriter !!!");
                e.printStackTrace();
            }
        }
    }
    public List<Villa> readFileVillaCSV() {
        Map<String, String> mapping = new HashMap<String, String>();
        for (String s : FILE_HEADER_OF_VILLA) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<Villa> strategy = new HeaderColumnNameTranslateMappingStrategy<Villa>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<Villa> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_VILLA));
            csvToBean = new CsvToBeanBuilder<Villa>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return csvToBean.parse();
    }
    public List<House> readFileHouseCSV() {
        Map<String, String> mapping = new HashMap<String, String>();
        for (String s : FILE_HEADER_OF_HOUSE) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<House> strategy = new HeaderColumnNameTranslateMappingStrategy<House>();
        strategy.setType(House.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<House> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_HOUSE));
            csvToBean = new CsvToBeanBuilder<House>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return csvToBean.parse();
    }
    public List<Room> readFileRoomCSV() {
        Map<String, String> mapping = new HashMap<String, String>();
        for (String s : FILE_HEADER_OF_ROOM) {
            mapping.put(s, s);
        }
        HeaderColumnNameTranslateMappingStrategy<Room> strategy = new HeaderColumnNameTranslateMappingStrategy<Room>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(mapping);
        CsvToBean<Room> csvToBean = null;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(PATH_FILE_ROOM));
            csvToBean = new CsvToBeanBuilder<Room>(csvReader)
                    .withMappingStrategy(strategy)
                    .withSeparator(COMMA_DELIMITER)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return csvToBean.parse();
    }
}
