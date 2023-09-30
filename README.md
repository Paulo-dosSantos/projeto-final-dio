# Santander Dev Week 2023

##Diagrama de classes

```mermaid

classDiagram
    class User {
        - name: string
        - account: Account
        - features: Feature
        - card: Card
        - news: News
        
       
    }

    class Account {
        - accountNumber: string
        - accountAgency: string
        - accountBalance: float
        - accountLimit: float
       } 
        

    class Feature {
        - icon: string
        - description: string
        
        
    }

    class Card {
        - number: string
        - limit: float
        
        
    }

    class News {
        - icon: string
        - description: string
        
        
}
    User "1" *--> "1"Account 
    User "1" *--> "N" Feature 
    User "1" *--> "1" Card 
    User "1" *--> "1"News 

```
