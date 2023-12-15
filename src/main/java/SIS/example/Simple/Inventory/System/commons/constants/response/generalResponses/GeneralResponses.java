package SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses;

public interface GeneralResponses {
    String BAD_REQUEST_RESPONSE = "The request was poorly made";
    String INTERNAL_SERVER_ERROR_RESPONSE = "There were a error in the system";
    String CONFLICT_RESPONSE = "There was a conflict in the mapping";
    String WRONG_METHOD_RESPONSE = "The method in the request is not correct";
    String ACCESS_FORBIDDEN_RESPONSE = "The user is not allowed to access to this services, only the administrators";
    String URL_NOT_FOUND = "The url requested doesn't exist";
}