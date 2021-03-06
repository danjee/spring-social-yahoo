spring-social-yahoo
===================


[![Build Status](https://travis-ci.org/gabrielruiu/spring-social-yahoo.svg?branch=master)](https://travis-ci.org/gabrielruiu/spring-social-yahoo)

Spring Social Yahoo is an extension based on Spring Social that provides functionality to communicate with the Yahoo Social Rest API.
You can find the full documentation at
[Yahoo's developer website](https://developer.yahoo.com/social/rest_api_guide/ysp_api_book.html).
Before proceeding with using this library, please consult the **Notes** section.
The best way to learn how use the library is to consult the [Spring Social documentation](http://docs.spring.io/spring-social/docs/current/reference/htmlsingle/) and
apply those principles for the classes specific to Yahoo.

**Do not hesitate to point out any issues and I am very open to suggestions, both in terms of implementation and documentation**

# Changelist

## 1.0.0.RELEASE
- first version release

# Notes

- not all endpoints and functionalities are implemented from tha Yahoo Social API; if there are requests to implement some extras,
please leave me a message and I will oblige with a response
- when implementing a connection repository, note that the default JdbcUsersConnectionRepository.sql constructs a table
whose max length for the access token is 255, which is less than the length of the token received from
Yahoo (about 700 characters), so you need to copy the original JdbcUsersConnectionRepository.sql file and modify
the max length of the **accessToken** column (you can go for 1000 max length)
- you can give *spring-social-yahoo* a try by cloning the forked repo of spring-social-samples, available on my account
at https://github.com/gabrielruiu/spring-social-samples/tree/master/spring-social-quickstart
- most classes contain links to the Yahoo documentation website, so you can consult the information there as well
- I would appreciate very much if you would take the time to give me a short email describing your usage of this library,
just so I can get a feeling of how useful the library is

# Tips
- if you want to build a filter for the Contacts resource (see *ContactsFilter*), you will most likely be using
several enums to construct it:

```java
ContactsFilter filter = new ContactsFilter()
        .withAndFilter(FieldType.EMAIL, SearchFilter.SearchFilterKey.PRESENT, "1")
        .sortBy(FieldType.EMAIL)
        .sortOrder(SortOrder.Order.DESC);
Contacts contacts = yahoo.contactsOperations().getContacts(filter);
```
These enums can take up some space on a single line, so to reduce the clutter, use static imports for each enum:

```java
import static org.springframework.social.yahoo.filter.SearchFilter.SearchFilterConstraint.PRESENT;
import static org.springframework.social.yahoo.filter.SortOrder.Order.DESC;
import static org.springframework.social.yahoo.module.FieldType.EMAIL;

///other code
ContactsFilter filter = new ContactsFilter()
        .withAndFilter(EMAIL, PRESENT, "1")
        .sortBy(EMAIL)
        .sortOrder(DESC);
Contacts contacts = yahoo.contactsOperations().getContacts(filter);
```

## At the time of writing (December 2014)
- the [documentation website](https://developer.yahoo.com/social/rest_api_guide/ysp_api_book.html) crashes from time to time and cannot be accessed, it comes and goes
- calls to [individual field resources](https://developer.yahoo.com/social/rest_api_guide/field-resource.html) fail
  with 404 responses
- the [Yahoo Social API Explorer](http://ydndemo.com/yahoo_social_api_explorer/) is unavailable, probably lack of
maintenance; see details [here](https://developer.yahoo.com/social/rest_api_guide/api_explorer.html)

# What is supported

- only JSON payloads are used
- only the Contacts API is implemented
- the following endpoints are implemented:

| Resource | Methods | Notes
| ------------- |-------------| ------ |
| [Contacts](https://developer.yahoo.com/social/rest_api_guide/contacts-resource.html) | GET | |
| [Contacts by category name](https://developer.yahoo.com/social/rest_api_guide/category-resource.html) | GET | |
| [Contacts filtering](https://developer.yahoo.com/social/rest_api_guide/contacts_resource-filters.html) | GET | |
| [Contact](https://developer.yahoo.com/social/rest_api_guide/contact-resource.html)   | GET | |
| [Categories](https://developer.yahoo.com/social/rest_api_guide/categories-resource.html) | GET |  |
| [Categories by contact cid](https://developer.yahoo.com/social/rest_api_guide/categories-by-contact-id-resource.html) | GET | API returns a 404 response |
