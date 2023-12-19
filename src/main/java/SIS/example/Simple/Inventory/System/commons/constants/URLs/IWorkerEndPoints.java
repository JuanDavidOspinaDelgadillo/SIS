package SIS.example.Simple.Inventory.System.commons.constants.URLs;

public interface IWorkerEndPoints {
    String URL_BASE_WORKER = "/worker";
    String URL_REGISTER_WORKER = "/register";
    String URL_READ_A_WORKER = "/read{workerId}";
    String URL_READ_ALL = "/read_all";
    String URL_READ_ALL_PRODUCTS_BY_WORKER = "/read_all_products{workerId}";
    String URL_UPDATE_WORKER = "/update";
    String URL_DELETE_WORKER = "/delete{workerId}";
}