package cat.tecnocampus.aop;


import cat.tecnocampus.domain.Classroom;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class);


    //1 i 3
    @Pointcut("execution(* cat.tecnocampus.UseCases.ClassroomUseCases.*(..)) && args(aux))")
    public void pointcutSingleAtributeClassroom(Classroom aux) {
    }


    @Before("pointcutSingleAtributeClassroom(aux)")
    public void atributeClassrooom(Classroom aux) {
        logger.info("Working with a classroom");
    }


    //2 i 4
    @Pointcut("execution(* cat.tecnocampus.UseCases.ClassroomUseCases.find*(..))")
    public void pointcutFind() {
    }


    @After("pointcutFind()")
    public void find() {
        logger.info("Finding classrooms");
    }


    //3 i 5
    @Pointcut("execution(* cat.tecnocampus.UseCases.ClassroomUseCases.insertBatch(..))")
    public void pointcutInsertBatch() {
    }


    //Around pointcut. Note that this method must return what the proxied method is supposed to return
    @Around("pointcutInsertBatch()")
    public int[] insertBatch(ProceedingJoinPoint jp) {

        try {

            logger.info("Before multiple insert");
            int[] aux = (int[]) jp.proceed();
            logger.info("After multiple insert");
            return aux;

        } catch (Throwable throwable) {

            logger.info("Showing notes: Something went wrong");
            throwable.printStackTrace();
            int[] var = null;
            return var;

        }
    }


}