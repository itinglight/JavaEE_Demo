
public class invoice {
    public void printinvoice(){
        System.out.println("This is the content of the invoice!");
    }
}

class Decorator extends invoice{
    protected invoice ticket;
    public Decorator(invoice t){
        ticket=t;
    }

    public void printinvoice(){
        if(ticket!=null){
            ticket.printinvoice();
        }
    }
}

class HeadDecorator extends Decorator{
    public HeadDecorator(invoice t){
        super(t);
    }

    @Override
    public void printinvoice() {
        System.out.println("This is the header of the invoice!");
        super.printinvoice();
    }
}

class  FootDecorator extends Decorator{
    public FootDecorator(invoice t){
        super(t);
    }

    @Override
    public void printinvoice() {

        super.printinvoice();
        System.out.println("This is the footnote of the invoice!");
    }
}

class test{
    public static void main(String[] args) {
        invoice t =new invoice();
        invoice ticket;
        ticket=new HeadDecorator(new FootDecorator(t));
        ticket.printinvoice();
        System.out.println("----------------------");

        ticket=new FootDecorator(new HeadDecorator(null));
        ticket.printinvoice();
    }
}
