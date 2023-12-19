package SIS.example.Simple.Inventory.System.commons.constants.URLs;

public interface ICategoryEndPoints {
    String URL_BASE_CATEGORY = "/category";
    String URL_REGISTER_CATEGORY = "/register";
    String URL_READ_A_CATEGORY = "/read{categoryId}";
    String URL_READ_ALL_CATEGORY = "/read_all";
    String URL_READ_ALL_PRODUCTS_BY_CATEGORY = "/read_all_products{categoryId}";
    String URL_UPDATE_CATEGORY = "/update";
    String URL_DELETE_CATEGORY = "/delete{categoryId}";
}