package Products;

public abstract class DigitalProduct extends Product {

    @Override
    public MediumType getMediumType()
    {
        return MediumType.Digital;
    } 
}
