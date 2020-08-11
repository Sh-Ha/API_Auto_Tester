Feature: Test Get User API

Scenario Outline: Use data driver to send data driven multiple requests and carry out mass verification/automation

Given Test Get User API End pont "<endpoint>" is deployed verificatrion data driver "<vfilepath>" is ready 
When Test Get User API Tester send a request at "<path>" 
Then Test Get User API header content and JSONPath value Verification is carried out via data driver from "<vfilepath>" at worksheet <sheetno> from row <row_low_watrmark> to row <row_high_watrmark> feed and verification data is pulled from columns <parameter_colno> <jpath_colno> and <jval_colno>
And Test Get User API Gather all soft /hard asertion report

Examples:
|      endpoint    | vfilepath | path | sheetno | row_low_watrmark |row_high_watrmark | parameter_colno | jpath_colno | jval_colno |
|https://bpdts-test-app-v2.herokuapp.com|C:\\data\\exceldata\\data_.xlsx | /user/{para} | 1 | 1 | 4 | 0 | 1 | 2 |
