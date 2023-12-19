package SIS.example.Simple.Inventory.System.commons.constants.URLs;

public interface IProductEndPoints {
    String URL_BASE_PRODUCT = "/product";
    String URL_REGISTER_PRODUCT = "/register";
    String URL_READ_A_PRODUCT = "/read{productId}";
    String URL_READ_ALL_PRODUCTS = "/read_all";
    String URL_UPDATE_A_PRODUCT = "/update";
    String URL_DELETE_A_PRODUCT = "/delete{productId}";
}