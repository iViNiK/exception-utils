# exception-utils

## Abstract

The management of the exceptions is realized through the feature of the ControllerAdvice offered by Spring Boot which allows to centralize in a single class the logic for the management of errors through appropriate Annotation.
The RestExceptionHandler class represents the reference implementation for handling system errors (RuntimeException) and business exceptions (BusinessException). The handler uses an appropriate data structure (represented by the ApiError class) to expose the details of the error to the caller.
The data structure includes the following fields:

- **businessErrorCode** that is the business error encoding corresponding to a BusinessException
- **statusCode** the http status of the REST call (404 Not Found, 409 Conflict ...)
- **message** the default message representing the error description
- **debugMessage** further detail of the error useful for the developer to understand the nature of the error
- **timestamp** timestamp of the error event

Each BusinessException will be associated with the http 409-CONFLICT status while the type of application error will be specified through an appropriate coding with which set value of the businessErrorCode field (E.g. ERR-001).

## License
Copyright &copy;2019 by Vinicio Flamini <io@vinicioflamini.it>
