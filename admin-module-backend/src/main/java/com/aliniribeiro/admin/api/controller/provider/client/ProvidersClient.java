package com.aliniribeiro.admin.api.controller.provider.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import providers.wsdl.*;

public class ProvidersClient extends WebServiceGatewaySupport {

    private final String PROVIDERS_API_LINK_ID = "66155469879546670340";
    private final String PROVIDERS_API_LINK_NAME = "PIDECOR";
    private final String CALL_BACK = "http://spring.io/guides/gs-producing-web-service/";
    private final String PROVIDER_HTTP = "http://localhost:8081/ws/providers";

    public GetProvidersByIdResponse getProviderById(String id) {
        GetProvidersByIdRequest request = new GetProvidersByIdRequest();
        request.setId(id);

        GetProvidersByIdResponse response = (GetProvidersByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PROVIDER_HTTP, request,
                        new SoapActionCallback(CALL_BACK + "getProvidersByIdRequest"));
        return response;
    }

    public GetAllProvidersResponse getAllproviders() {
        GetAllProvidersRequest request = new GetAllProvidersRequest();
        GetAllProvidersResponse response = (GetAllProvidersResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PROVIDER_HTTP, request,
                        new SoapActionCallback(CALL_BACK + "getAllProvidersRequest"));
        return response;
    }

    public GetMyProvidersResponse getMyProviders() {
        GetMyProvidersRequest request = new GetMyProvidersRequest();
        request.setCompanyId(PROVIDERS_API_LINK_ID);
        GetMyProvidersResponse response = (GetMyProvidersResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PROVIDER_HTTP, request,
                        new SoapActionCallback(CALL_BACK + "getMyProvidersRequest"));
        return response;
    }

    public ActivateProviderResponse activateProvider(String providerId) {
        ActivateProviderRequest request = new ActivateProviderRequest();
        request.setCompanyId(PROVIDERS_API_LINK_ID);
        request.setCompanyname(PROVIDERS_API_LINK_NAME);
        request.setId(providerId);
        ActivateProviderResponse response = (ActivateProviderResponse) getWebServiceTemplate().marshalSendAndReceive(PROVIDER_HTTP, request,
                        new SoapActionCallback(CALL_BACK + "activateProviderRequest"));
        return response;
    }

    public DisableProviderResponse disableProvider(String providerId) {
        DisableProviderRequest request = new DisableProviderRequest();
        request.setCompanyId(PROVIDERS_API_LINK_ID);
        request.setCompanyname(PROVIDERS_API_LINK_NAME);
        request.setId(providerId);
        DisableProviderResponse response = (DisableProviderResponse) getWebServiceTemplate().marshalSendAndReceive(PROVIDER_HTTP, request,
                new SoapActionCallback(CALL_BACK + "disableProviderRequest"));
        return response;
    }


    public GetAllItemsResponse getAllItems(String providerId){
        GetAllItemsRequest request = new GetAllItemsRequest();
        request.setId(providerId);
        GetAllItemsResponse response = (GetAllItemsResponse) getWebServiceTemplate().marshalSendAndReceive(PROVIDER_HTTP, request,
                new SoapActionCallback(CALL_BACK + "getAllItemsRequest"));
        return response;
    }

    public GetItemsByIdResponse getItemsById(String itemId){
        GetItemsByIdRequest request = new GetItemsByIdRequest();
        request.setId(itemId);
        GetItemsByIdResponse response = (GetItemsByIdResponse) getWebServiceTemplate().marshalSendAndReceive(PROVIDER_HTTP, request,
                new SoapActionCallback(CALL_BACK + "getItemsByIdRequest"));
        return response;
    }

    public CreateOrderResponse createOrder(Order order){
        CreateOrderRequest request = new CreateOrderRequest();
        request.setOrder(order);
        CreateOrderResponse response = (CreateOrderResponse) getWebServiceTemplate().marshalSendAndReceive(PROVIDER_HTTP, request,
                new SoapActionCallback(CALL_BACK + "createOrderRequest"));
        return response;
    }

    public GetOrderStatusResponse getOrderStatus(String orderId){
        GetOrderStatusRequest request = new GetOrderStatusRequest();
        request.setId(orderId);
        GetOrderStatusResponse response = (GetOrderStatusResponse) getWebServiceTemplate().marshalSendAndReceive(PROVIDER_HTTP, request,
                new SoapActionCallback(CALL_BACK + "getOrderStatusRequest"));
        return response;
    }
}
