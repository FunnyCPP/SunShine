import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/database";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
}

public class Item {
    private String barcode;
    private String name;
    private String description;
    private int roomId;
    private int buildingId;
    private ItemState state;
    private Date purchaseDate;
    private Date introductionDate;

    public Item(String barcode, String name, String description, int roomId, int buildingId, ItemState state,
                Date purchaseDate, Date introductionDate) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.roomId = roomId;
        this.buildingId = buildingId;
        this.state = state;
        this.purchaseDate = purchaseDate;
        this.introductionDate = introductionDate;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public ItemState getState() {
        return state;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Date getIntroductionDate() {
        return introductionDate;
    }
}

public enum ItemState {
    SPRAWNY("sprawny"),
    USZKODZONY("uszkodzony"),
    ZEZLOMOWANY("zezłomowany");

    private final String state;

    ItemState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

public class AddItemCommand {
    private String barcode;
    private String name;
    private int roomId;
    private int buildingId;
    private ItemState state;

    public AddItemCommand(String barcode, String name, int roomId, int buildingId, ItemState state) {
        this.barcode = barcode;
        this.name = name;
        this.roomId = roomId;
        this.buildingId = buildingId;
        this.state = state;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public ItemState getState() {
        return state;
    }
}

public class AddItemCommandHandler {
    private ItemRepository itemRepository;

    public AddItemCommandHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void handle(AddItemCommand command) {
        Item item = new Item(command.getBarcode(), command.getName(), "", command.getRoomId(), command.getBuildingId(), command.getState(), null, null);
        itemRepository.add(item);
    }
}

public class ItemRepository {
    private DatabaseConnection databaseConnection;

    public ItemRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void add(Item item) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO items (barcode, name, room_id, building_id, state) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, item.getBarcode());
            statement.setString(2, item.getName());
            statement.setInt(3, item.getRoomId());
            statement.setInt(4, item.getBuildingId());
            statement.setString(5, item.getState().getState());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String barcode) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE barcode = ?");
            statement.setString(1, barcode);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Item item) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE items SET name = ?, room_id = ?, building_id = ?, state = ? WHERE barcode = ?");
            statement.setString(1, item.getName());
            statement.setInt(2, item.getRoomId());
            statement.setInt(3, item.getBuildingId());
            statement.setString(4, item.getState().getState());
            statement.setString(5, item.getBarcode());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(String barcode) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM items WHERE barcode = ?");
            statement.setString(1, barcode);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteItem(String barcode) {
        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE barcode = ?");
            statement.setString(1, barcode);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class DeleteItemCommand {
    private String barcode;

    public DeleteItemCommand(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

public class DeleteItemCommandHandler {
    private ItemRepository itemRepository;

    public DeleteItemCommandHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void handle(DeleteItemCommand deleteItemCommand) {
        String barcode = deleteItemCommand.getBarcode();

        if (itemRepository.exists(barcode)) {
            itemRepository.deleteItem(barcode);
        } else {
            throw new ItemNotFoundException("Przedmiot o podanym kodzie kreskowym nie istnieje.");
        }
    }
}

public class UpdateItemCommand {
    private String barcode;
    private String name;
    private String description;
    private int roomId;
    private int buildingId;
    private ItemState state;

    public UpdateItemCommand(String barcode, String name, String description, int roomId, int buildingId, ItemState state) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.roomId = roomId;
        this.buildingId = buildingId;
        this.state = state;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public ItemState getState() {
        return state;
    }
}

public class UpdateItemCommandHandler {
    private ItemRepository itemRepository;

    public UpdateItemCommandHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void handle(UpdateItemCommand updateItemCommand) {
        String barcode = updateItemCommand.getBarcode();

        if (itemRepository.exists(barcode)) {
            Item item = new Item(updateItemCommand.getBarcode(), updateItemCommand.getName(), updateItemCommand.getDescription(),
                    updateItemCommand.getRoomId(), updateItemCommand.getBuildingId(), updateItemCommand.getState(),
                    null, null);
            itemRepository.update(item);
        } else {
            throw new ItemNotFoundException("Przedmiot o podanym kodzie kreskowym nie istnieje.");
        }
    }
}

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}

