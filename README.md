# BomSQS

## 개요
나는 `AWS SQS`를 대충 사용할 줄 알지만 구축부터는 못한다.  
나를 위해 그리고 나와 같은 이를 위한 `AWS SQS` **구축**부터 **사용**까지 정복 프로젝트!

## 프로젝트 구성
본 프로젝트는 기본적으로 Kotlin 언어와 multi-module 프로젝트 구성을 채택하여 진행합니다.
```
bomsqs
ㄴ buildSrc
ㄴ bom-api
ㄴ bom-core
ㄴ bom-worker
ㄴ bom-clients
   ㄴ bom-message
```
### buildSrc
Kotlin 의존성을 관리하는 모듈 

### bom-api
외부요청을 받아들이는 모듈

### bom-core
비즈니스 로직을 표현하고있는 모듈

### bom-worker
비동기적으로 sqs 메세지를 처리하는 모듈

### bom-clients:bom-message
AWS SQS 를 사용하기 위한 의존성을 가지고 있는 모듈
