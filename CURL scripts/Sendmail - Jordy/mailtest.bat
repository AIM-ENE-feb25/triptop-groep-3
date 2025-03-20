@echo off
curl -X POST "https://sendmail-ultimate-email-sender.p.rapidapi.com/send-email" ^
-H "x-rapidapi-key: 72f7d0739amsh83ed1a4ef1a5c42p1145b2jsn3a72da8a01bc" ^
-H "x-rapidapi-host: sendmail-ultimate-email-sender.p.rapidapi.com" ^
-H "Content-Type: application/json" ^
-d "{\"sendTo\":\"vandenbroekjordy@gmail.com\",\"replyTo\":\"your.email@gmail.com\",\"isHtml\":false,\"title\":\"Checking In\",\"body\":\"Hello Friend, Hope you doing well!\"}"
pause
