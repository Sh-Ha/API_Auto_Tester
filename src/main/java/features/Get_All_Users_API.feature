Feature: Test Get_All_Users API

Scenario Outline: Use data driver to carry out mass verification/automation

Given Test Get All Users API End pont "<endpoint>" is deployed verificatrion data driver "<vfilepath>" is ready 
When Test Get All Users API Tester send a request at "<path>" 
Then Test Get All Users API header JSONPath value Verification is carried out via data driver from "<vfilepath>" at worksheet <sheetno> from row <row_low_watrmark> to row <row_high_watrmark> feed and verification data is pulled from columns <jpath_colno> and <jval_colno>
And Test Get All Users API Gather all soft /hard asertion report

Examples:
|      endpoint    | vfilepath | path | sheetno | row_low_watrmark |row_high_watrmark | parameter_colno | jpath_colno | jval_colno |
|https://bpdts-test-app-v2.herokuapp.com|C:\\data\\exceldata\\data_.xlsx | /users | 3 | 1 | 4 | 0 | 1 | 2 |

