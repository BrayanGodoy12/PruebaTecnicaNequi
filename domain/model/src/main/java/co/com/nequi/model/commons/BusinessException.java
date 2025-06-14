package co.com.nequi.model.commons;

import co.com.nequi.model.commons.message.BusinessErrorMessage;

public class BusinessException extends RuntimeException {
    private final BusinessErrorMessage errorMessage;

    public BusinessException(BusinessErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public BusinessErrorMessage getErrorMessage() {
        return errorMessage;
    }
}