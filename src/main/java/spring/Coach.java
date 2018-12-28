package spring;

public interface Coach {

    String getDailyWorkout();
    
    String getDailyFortune();

    FortuneService getFortuneService();

    void setAge(String age);

    void setFlag(boolean flag);

    String getAge();

    void setFortuneService(FortuneService fortuneService);
}
