@echo off
set /p token="Voer de 6-cijferige token in: "
curl --location --request POST "https://easy-authenticator.p.rapidapi.com/verify?secretCode=54PY2MYIW2X436MJS4O4SBICZJ6IZMID&token=%token%" ^
--header "X-RapidAPI-Key: 70a86ded3fmsh28c7c8558de8c7ep16db07jsn0d0a4e3c2dfa" ^
--header "x-rapidapi-host: easy-authenticator.p.rapidapi.com" ^
--header "Content-Type: application/x-www-form-urlencoded"
pause
