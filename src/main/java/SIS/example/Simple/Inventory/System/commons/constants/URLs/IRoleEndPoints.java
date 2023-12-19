package SIS.example.Simple.Inventory.System.commons.constants.URLs;

public interface IRoleEndPoints {
    String URL_BASE_ROLE = "/role";
    String URL_REGISTER_ROLE = "/register";
    String URL_READ_A_ROLE = "/read{roleId}";
    String URL_READ_ALL = "/read_all";
    String URL_READ_ALL_WORKERS_BY_ROLE = "/read_all_workers{roleId}";
    String URL_UPDATE_ROLE = "/update";
    String URL_DELETE_ROLE = "/delete{roleId}";
}