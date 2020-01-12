
*** Settings ***
Documentation     Simple example using SeleniumLibrary.
Library           SeleniumLibrary


*** Variables ***
${SERVER}       automationpractice.com
${BROWSER}      Chrome
${DELAY}        0
${VALID EMAIL}   testselenium-1@wp.pl
${INVALID EMAIL}     test@wp.pl
${VALID PASSWORD}   testselenium
${INVALID PASSWORD}     test123
${MAIN URL}    http://${SERVER}/index.php
${SIGNIN URL}    http://${SERVER}/index.php?controller=authentication&back=my-account
${CONTACT US URL}  http://${SERVER}/index.php?controller=contact
${ALERT URL}    http://${SERVER}/index.php?controller=authentication


*** Test Cases ***
Navigation
    Open Browser To Main Page
    Got To Contact Us Page
    Contact Us Page Should Be Open
    [Teardown]    Close Browser

Valid Login
    Set Selenium Speed     1
    Open Browser To Main Page
    Log In
    Input Email       ${VALID EMAIL}
    Input Password    ${VALID PASSWORD}
    Submit Credentials
    My Account Page Should Be Open
    [Teardown]    Close Browser

Invalid Login
    Set Selenium Speed     1
    Open Browser To Main Page
    Log In
    Input Email    ${INVALID EMAIL}
    Input Password    ${INVALID PASSWORD}
    Submit Credentials
    Alert Page Should Be Open
    [Teardown]    Close Browser

Invalid Registration
    Set Selenium Speed     1
    Open Browser To Main Page
    Log In
    Input Create Email    test1234@wp.pl
    Create Account
    Submit Account
    Alert Page Should Be Open
    [Teardown]    Close Browser




*** Keywords ***
Open Browser To Main Page
  Open Browser    ${MAIN URL}    ${BROWSER}
  Title Should Be    My Store

Got To Contact Us Page
    Click Element      xpath=//*[@id="contact-link"]/a

Contact Us Page Should Be Open
    Location Should Be  ${CONTACT US URL}

Input Email
    [Arguments]    ${email}
    Input Text    email    ${email}

Input Password
    [Arguments]    ${passwd}
    Input Text    passwd    ${passwd}

Log In
    Click Element   class=login

Submit Credentials
    Click Button    SubmitLogin

My Account Page Should Be Open
    Title Should Be    My account - My Store

Input Create Email
    [Arguments]    ${email}
    Input Text    email_create    ${email}

Create Account
    Click Button    xpath=//*[@id="SubmitCreate"]

Submit Account
    Click Button    xpath=//*[@id="submitAccount"]

Alert Page Should Be Open
    Location Should Be   ${ALERT URL}


