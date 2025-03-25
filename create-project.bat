@echo off
mkdir face-recognition-app
cd face-recognition-app
mkdir src\main\java\com\example\facerecognitionapp
mkdir src\main\java\com\example\facerecognitionapp\controller
mkdir src\main\java\com\example\facerecognitionapp\service
mkdir src\main\java\com\example\facerecognitionapp\config
mkdir src\main\java\com\example\facerecognitionapp\model
mkdir src\main\java\com\example\facerecognitionapp\dto
mkdir src\main\java\com\example\facerecognitionapp\util
echo // Main Spring Boot Application > src\main\java\com\example\facerecognitionapp\FaceRecognitionAppApplication.java
echo // Controller > src\main\java\com\example\facerecognitionapp\controller\FaceRecognitionController.java
echo // Service > src\main\java\com\example\facerecognitionapp\service\FaceRecognitionService.java
echo // S3 Service > src\main\java\com\example\facerecognitionapp\service\S3Service.java
echo // AWS Config > src\main\java\com\example\facerecognitionapp\config\AwsConfig.java
echo // Model > src\main\java\com\example\facerecognitionapp\model\FaceMatchResult.java
echo // DTO > src\main\java\com\example\facerecognitionapp\dto\FaceRecognitionRequest.java
echo // Utility > src\main\java\com\example\facerecognitionapp\util\ImageUtils.java
echo ✅ Project structure created successfully!
