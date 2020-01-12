*** Test Cases ***
Traingle Test
    ${result} =  Run Java Class With Args  ${mainClass}   2 3 4
    Should match     ${result.replace("\n", " ")}   Trojkat roznoramienny

Equilateral Triangle Test
    ${result} =  Run Java Class With Args  ${mainClass}   3 3 3
    Should match    ${result.replace("\n", " ")}   Trojkat rownoboczny

Isosceles Traingle Test
    ${result} =  Run Java Class With Args  ${mainClass}   2 2 3
    Should match    ${result.replace("\n", " ")}   Trojkat rownoramienny

Unrecognized Test
    ${result} =  Run Java Class With Args  ${mainClass}   2 3 7
    Should match    ${result.replace("\n", " ")}   nierozpoznano

Unrecognized Test 2 value
    ${result} =  Run Java Class With Args  ${mainClass}   1 2
    Should match     ${result.replace("\n", " ")}   nierozpoznano

Unrecognized Test 5 value
    ${result} =  Run Java Class With Args  ${mainClass}   2 2 2 2 4
    Should match     ${result.replace("\n", " ")}   nierozpoznano

Traingle Test
    ${result} =  Run Java Class With Args  ${mainClass}   1 1 3 3
    Should match     ${result.replace("\n", " ")}   Prostokat

Square Test
    ${result} =  Run Java Class With Args  ${mainClass}   1 1 1 1
    Should match    ${result.replace("\n", " ")}   Kwadrat

Quadrangle
    ${result} =  Run Java Class With Args  ${mainClass}   3 2 3 4
    Should match    ${result.replace("\n", " ")}   Czworobok

*** Settings ***
Documentation   Test figures
Library         OperatingSystem

*** Variables ***
${path}    ${CURDIR}
${mainClass}    Main

*** Keywords ***
Run Java Class With Args
    [Arguments]  ${class_name}  ${args}
    ${output}=   Run    java -cp ${path} ${class_name} ${args}
    [return]    ${output}
