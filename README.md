# homework_soap
Сделать SOAP веб сервис
 - сгенерировать с помощью плагина классы из xsd файла
 - работу сервиса проверить  с помощью SOAPUI
 - soap запрос ответ (тест или скрины) приложить к коду проекта
 
 # Методы
 ## getByEducation
 Возвращает все контакты с заданным образованием.
 Пример:
 ```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://smsoft.ru/non-rookie/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getByEducationRequest>
         <soap:Education>MAI</soap:Education>
      </soap:getByEducationRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## getByFirstNameAndLastName
Возвращает все контакты с заданными именем и фамилией.
Пример:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://smsoft.ru/non-rookie/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getByFirstNameAndLastNameRequest>
         <soap:LastName>Andrade</soap:LastName>
         <soap:FirstName>Usman</soap:FirstName>
      </soap:getByFirstNameAndLastNameRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## getByLastName
Возвращает все контакты с заданной фамилией.
Пример:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://smsoft.ru/non-rookie/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getByLastNameRequest>
         <soap:LastName>Romanov</soap:LastName>
      </soap:getByLastNameRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## getByOldestOrYoungest
Возвращает самого старшего/младшего из списка контактов.
Пример:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://smsoft.ru/non-rookie/soap">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getByOldestOrYoungestRequest>
         <soap:Extremum>OLDEST</soap:Extremum>
      </soap:getByOldestOrYoungestRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

WSDL: http://localhost:8080/soap-service/contacts.wsdl <br>
Скрины приложены.
