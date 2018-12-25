package UI;

import Products.Digital.DigitalBook;
import Products.Digital.DigitalGame;
import Products.Digital.DigitalMovie;
import Products.Digital.DigitalMusic;
import Products.IProduct;
import Products.Infos.BookInfo;
import Products.Infos.GameInfo;
import Products.Infos.MovieInfo;
import Products.Infos.MusicInfo;
import Products.Interfaces.IBook;
import Products.Interfaces.IGame;
import Products.Interfaces.IMovie;
import Products.Interfaces.IMusic;
import Products.MediumType;
import Products.Person;
import Products.Physical.PhysicalBook;
import Products.Physical.PhysicalGame;
import Products.Physical.PhysicalMovie;
import Products.Physical.PhysicalMusic;
import Products.ProductInfo;
import Products.ProductSystem;
import Products.ProductType;
import Users.UserSystem;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProductInfoScreen extends javax.swing.JFrame {
    
    private final ArrayList<JTextField> _clearList;
    private final ArrayList<JComponent> _enableList;
    
    private IProduct currentProduct;
    private MediumType currentMediumType;
    private ProductType currentProductType;
    
    public ProductInfoScreen() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        if(UserSystem.getLoggedInUser().isAdmin())
        {
            setTitle("Product Add");
            nameOutput.setEditable(true);
            relasedateOutput.setEditable(true);
            genreOutput.setEditable(true);
            languageOutput.setEditable(true);
            publisherOutput.setEditable(true);
            priceOutput.setEditable(true);
            bookIsbnOutput.setEditable(true);
            bookAuthorOutput.setEditable(true);
            bookPageCountOutput.setEditable(true);
            gameDevOutput.setEditable(true);
            gameEngineOutput.setEditable(true);
            gamePlatformsOutput.setEditable(true);
            movieBoxOfficeOutput.setEditable(true);
            movieCountryOutput.setEditable(true);
            movieDirectorOutput.setEditable(true);
            movieLengthOutput.setEditable(true);
            movieProducerOutput.setEditable(true);
            musicAlbumOutput.setEditable(true);
            musicArtistOutput.setEditable(true);
            musicLengthOutput.setEditable(true);
        }else{
            setTitle("Product Information");
        }
        this._clearList = new ArrayList<>(Arrays.asList(
                nameOutput,
                relasedateOutput,
                genreOutput,
                languageOutput,
                publisherOutput,
                priceOutput,
                bookIsbnOutput,
                bookAuthorOutput,
                bookPageCountOutput,
                gameDevOutput,
                gameEngineOutput,
                gamePlatformsOutput,
                movieBoxOfficeOutput,
                movieCountryOutput,
                movieDirectorOutput,
                movieLengthOutput,
                movieProducerOutput,
                musicAlbumOutput,
                musicArtistOutput,
                musicLengthOutput
        ));
        
        _enableList = new ArrayList<>(_clearList);
        _enableList.add(movieStarringOutput);
    }
    
    public void setUpForViewOrEdit(IProduct product, boolean canEdit) {
        this.currentProduct = product;
        this.currentMediumType = product.getMediumType();
        this.currentProductType = product.getProductType();
        
        fillGenericPanel(product.getProductInfo());
        fillSpecificPanel(product.getProductType(), product.getProductInfo());
        showSpecificPanel(product.getProductType());
        
        addButton.setVisible(false);
        updateButton.setVisible(canEdit);
    }
    
    public void setUpForAdd(MediumType mediumType, ProductType productType) {
        this.currentProduct = null;
        this.currentMediumType = mediumType;
        this.currentProductType = productType;
        
        clear();
        showSpecificPanel(productType);
        
        addButton.setVisible(true);
        updateButton.setVisible(false);
    }
    
    private void clear() {
        for (JTextField it : _clearList) {
            it.setText("");
        }
        
        movieStarringOutput.setModel(new DefaultListModel());
    }
    
    private void fillGenericPanel(ProductInfo info) {
        nameOutput.setText(info.getProductName());
        relasedateOutput.setText(info.getReleaseDate());
        genreOutput.setText(info.getGenre());
        languageOutput.setText(info.getLanguage());
        publisherOutput.setText(info.getPublisher());
        priceOutput.setText(Double.toString(info.getPrice()));
    }
    
    private void fillSpecificPanel(ProductType productType, ProductInfo info) {
        switch (productType) {
            case Book:
                fillSpecific((BookInfo) info);
                break;
                
            case Game:
                fillSpecific((GameInfo) info);
                break;
                
            case Movie:
                fillSpecific((MovieInfo) info);
                break;
                
            case Music:
                fillSpecific((MusicInfo) info);
                break;
        }
    }
    
    private void showSpecificPanel(ProductType type) {
        bookPanel.setVisible(false);
        gamePanel.setVisible(false);
        moviePanel.setVisible(false);
        musicPanel.setVisible(false);
        
        switch (type) {
            case Book:
                bookPanel.setVisible(true);
                break;
                
            case Game:
                gamePanel.setVisible(true);
                break;
                
            case Movie:
                moviePanel.setVisible(true);
                break;
                
            case Music:
                musicPanel.setVisible(true);
                break;
        }
    }
    
    private void fillSpecific(BookInfo info) {
        bookIsbnOutput.setText(Integer.toString(info.getIsbn()));
        bookAuthorOutput.setText(info.getAuthor().getFullName());
        bookPageCountOutput.setText(Integer.toString(info.getPageCount()));
    }
    
    private void fillSpecific(GameInfo info) {
        gameDevOutput.setText(info.getDeveloper().getFullName());
        gameEngineOutput.setText(info.getEngine());
        gamePlatformsOutput.setText(info.getPlatforms());
    }
    
    private void fillSpecific(MovieInfo info) {
        movieBoxOfficeOutput.setText(Double.toString(info.getBoxOffice()));
        movieCountryOutput.setText(info.getCountry());
        movieDirectorOutput.setText(info.getDirector().getFullName());
        movieLengthOutput.setText(info.getLength());
        movieProducerOutput.setText(info.getProducer());
        
        ArrayList<Person> starring = info.getStarring();
        
        DefaultListModel dlm = (DefaultListModel) movieStarringOutput.getModel();
        dlm.clear();
        
        for (Person it : starring) {
            dlm.addElement(it.getFullName());
        }
    }
    
    private void fillSpecific(MusicInfo info) {
        musicAlbumOutput.setText(info.getAlbum());
        musicArtistOutput.setText(info.getArtist().getFullName());
        musicLengthOutput.setText(info.getLength());
    }
    
    private IMusic createNewMusic() {
        MusicInfo info = collateMusicInfo();
        
        switch (currentMediumType) {
            case Digital:
                return new DigitalMusic(info);
                
            case Physical:
                return new PhysicalMusic(info);
        }
        
        return null;
    }
    
    private IMovie createNewMovie() {
        MovieInfo info = collateMovieInfo();
        
        switch (currentMediumType) {
            case Digital:
                return new DigitalMovie(info);
                
            case Physical:
                return new PhysicalMovie(info);
        }
        
        return null;
    }
    
    private IGame createNewGame() {
        GameInfo info = collateGameInfo();
        
        switch (currentMediumType) {
            case Digital:
                return new DigitalGame(info);
                
            case Physical:
                return new PhysicalGame(info);
        }
        
        return null;
    }
    
    private IBook createNewBook() {
        BookInfo info = collateBookInfo();
        
        switch (currentMediumType) {
            case Digital:
                return new DigitalBook(info);
                
            case Physical:
                return new PhysicalBook(info);
        }
        
        return null;
    }
    
    private MusicInfo collateMusicInfo() {
        // specific
        String album = musicAlbumOutput.getText();
        
        String[] artistNames = musicArtistOutput.getText().split(" ");
        Person artist = new Person(artistNames[0], artistNames[1]);
        
        String length = musicLengthOutput.getText();
        String producer = musicProducerOutput.getText();
        
        // generic
        String releaseDate = relasedateOutput.getText();
        double price = Double.parseDouble(priceOutput.getText());
        String productName = nameOutput.getText();
        String publisher = publisherOutput.getText();
        String genre = genreOutput.getText();
        String language = languageOutput.getText();
        
        return new MusicInfo(album, artist, length, producer,
                releaseDate, price, productName, publisher, genre, language);
    }
    
    private MovieInfo collateMovieInfo() {
        // String producer, Person director, String country, ArrayList<Person> starring, int length, double boxOffice,
        
        // specific
        String producer = movieProducerOutput.getText();
        
        String[] directorNames = movieDirectorOutput.getText().split(" ");
        Person director = new Person(directorNames[0], directorNames[1]);
        
        String country = movieCountryOutput.getText();
        String length = movieLengthOutput.getText();
        double boxOffice = Double.parseDouble(movieBoxOfficeOutput.getText());
        
        // generic
        String releaseDate = relasedateOutput.getText();
        double price = Double.parseDouble(priceOutput.getText());
        String productName = nameOutput.getText();
        String publisher = publisherOutput.getText();
        String genre = genreOutput.getText();
        String language = languageOutput.getText();
        
        return new MovieInfo(producer, director, country, parseMovieStarring(), length, boxOffice,
                releaseDate, price, productName, publisher, genre, language);
    }
    
    private ArrayList<Person> parseMovieStarring() {
        ArrayList<Person> result = new ArrayList<>();
        
        return result;
    }
    
    private GameInfo collateGameInfo() {
        // specific
        String platforms = gamePlatformsOutput.getText();
        
        String[] developerNames = gameDevOutput.getText().split(" ");
        Person developer = new Person(developerNames[0], developerNames[1]);
        
        String engine = gameEngineOutput.getText();
        
        // generic
        String releaseDate = relasedateOutput.getText();
        double price = Double.parseDouble(priceOutput.getText());
        String productName = nameOutput.getText();
        String publisher = publisherOutput.getText();
        String genre = genreOutput.getText();
        String language = languageOutput.getText();
        
        return new GameInfo(platforms, engine, developer,
                releaseDate, price, productName, publisher, genre, language);
    }
    
    private BookInfo collateBookInfo() {
        // int pageCount, int isbn, Person author,
        
        // specific
        int pageCount = Integer.parseInt(bookPageCountOutput.getText());
        
        int isbn = Integer.parseInt(bookIsbnOutput.getText());
        
        String[] authorNames = bookAuthorOutput.getText().split(" ");
        Person author = new Person(authorNames[0], authorNames[1]);
        
        // generic
        String releaseDate = relasedateOutput.getText();
        double price = Double.parseDouble(priceOutput.getText());
        String productName = nameOutput.getText();
        String publisher = publisherOutput.getText();
        String genre = genreOutput.getText();
        String language = languageOutput.getText();
        
        return new BookInfo(pageCount, isbn, author,
                releaseDate, price, productName, publisher, genre, language);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genericPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        priceOutput = new javax.swing.JTextField();
        publisherOutput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        languageOutput = new javax.swing.JTextField();
        genreOutput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        relasedateOutput = new javax.swing.JTextField();
        nameOutput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        specificPanelsHolder = new javax.swing.JPanel();
        bookPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bookAuthorOutput = new javax.swing.JTextField();
        bookIsbnOutput = new javax.swing.JTextField();
        bookPageCountOutput = new javax.swing.JTextField();
        gamePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        gamePlatformsOutput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gameEngineOutput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        gameDevOutput = new javax.swing.JTextField();
        moviePanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        movieProducerOutput = new javax.swing.JTextField();
        movieDirectorOutput = new javax.swing.JTextField();
        movieCountryOutput = new javax.swing.JTextField();
        movieLengthOutput = new javax.swing.JTextField();
        movieBoxOfficeOutput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieStarringOutput = new javax.swing.JList<>();
        musicPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        musicArtistOutput = new javax.swing.JTextField();
        musicLengthOutput = new javax.swing.JTextField();
        musicAlbumOutput = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        musicProducerOutput = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(724, 375));
        setResizable(false);

        genericPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("PRICE");

        priceOutput.setEditable(false);

        publisherOutput.setEditable(false);

        jLabel6.setText("PUBLISHER");

        jLabel4.setText("LANGUAGE");

        languageOutput.setEditable(false);

        genreOutput.setEditable(false);

        jLabel3.setText("GENRE");

        jLabel2.setText("RELEASE DATE");

        relasedateOutput.setEditable(false);

        nameOutput.setEditable(false);

        jLabel1.setText("NAME");

        javax.swing.GroupLayout genericPanelLayout = new javax.swing.GroupLayout(genericPanel);
        genericPanel.setLayout(genericPanelLayout);
        genericPanelLayout.setHorizontalGroup(
            genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genericPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(genericPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(publisherOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(genericPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(languageOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(genericPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(relasedateOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(genericPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(nameOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genericPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(priceOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(genericPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(genreOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        genericPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        genericPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {genreOutput, languageOutput, nameOutput, priceOutput, publisherOutput, relasedateOutput});

        genericPanelLayout.setVerticalGroup(
            genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genericPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(relasedateOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(genreOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(languageOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(publisherOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priceOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        specificPanelsHolder.setLayout(new java.awt.CardLayout());

        bookPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("AUTHOR");

        jLabel11.setText("ISBN");

        jLabel12.setText("PAGE COUNT");

        bookAuthorOutput.setEditable(false);

        bookIsbnOutput.setEditable(false);

        bookPageCountOutput.setEditable(false);

        javax.swing.GroupLayout bookPanelLayout = new javax.swing.GroupLayout(bookPanel);
        bookPanel.setLayout(bookPanelLayout);
        bookPanelLayout.setHorizontalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookPageCountOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookAuthorOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookIsbnOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bookPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12});

        bookPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bookAuthorOutput, bookIsbnOutput, bookPageCountOutput});

        bookPanelLayout.setVerticalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookIsbnOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(25, 25, 25)
                .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bookAuthorOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(bookPageCountOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        specificPanelsHolder.add(bookPanel, "card2");

        gamePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("PLATFORMS");

        gamePlatformsOutput.setEditable(false);

        jLabel8.setText("GAME ENGINE");

        gameEngineOutput.setEditable(false);

        jLabel9.setText("DEVELOPER");

        gameDevOutput.setEditable(false);

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gameDevOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gamePlatformsOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gameEngineOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gamePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gameDevOutput, gameEngineOutput, gamePlatformsOutput});

        gamePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel7, jLabel8, jLabel9});

        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(gamePlatformsOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameEngineOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(25, 25, 25)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(gameDevOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        specificPanelsHolder.add(gamePanel, "card3");

        moviePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("PRODUCER");

        jLabel14.setText("DIRECTOR");

        jLabel15.setText("COUNTRY");

        jLabel16.setText("STARRING");

        jLabel17.setText("LENGHT");

        jLabel18.setText("BOX OFFICE");

        movieProducerOutput.setEditable(false);

        movieDirectorOutput.setEditable(false);

        movieCountryOutput.setEditable(false);

        movieLengthOutput.setEditable(false);

        movieBoxOfficeOutput.setEditable(false);

        jScrollPane1.setViewportView(movieStarringOutput);

        javax.swing.GroupLayout moviePanelLayout = new javax.swing.GroupLayout(moviePanel);
        moviePanel.setLayout(moviePanelLayout);
        moviePanelLayout.setHorizontalGroup(
            moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(moviePanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(30, 30, 30)
                        .addComponent(movieProducerOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(30, 30, 30)
                        .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movieLengthOutput)
                            .addComponent(movieBoxOfficeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(moviePanelLayout.createSequentialGroup()
                        .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(30, 30, 30)
                        .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(moviePanelLayout.createSequentialGroup()
                                .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(movieCountryOutput)
                                    .addComponent(movieDirectorOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );

        moviePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18});

        moviePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {movieBoxOfficeOutput, movieCountryOutput, movieDirectorOutput, movieLengthOutput, movieProducerOutput});

        moviePanelLayout.setVerticalGroup(
            moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(moviePanelLayout.createSequentialGroup()
                        .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(movieProducerOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(movieDirectorOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(moviePanelLayout.createSequentialGroup()
                        .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(movieLengthOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(movieBoxOfficeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(movieCountryOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(moviePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        specificPanelsHolder.add(moviePanel, "card4");

        musicPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setText("ARTIST");

        jLabel20.setText("LENGHT");

        jLabel21.setText("ALBUM");

        musicArtistOutput.setEditable(false);

        musicLengthOutput.setEditable(false);

        musicAlbumOutput.setEditable(false);

        jLabel22.setText("Producer");

        musicProducerOutput.setEditable(false);

        javax.swing.GroupLayout musicPanelLayout = new javax.swing.GroupLayout(musicPanel);
        musicPanel.setLayout(musicPanelLayout);
        musicPanelLayout.setHorizontalGroup(
            musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(musicAlbumOutput)
                    .addComponent(musicProducerOutput)
                    .addComponent(musicLengthOutput)
                    .addComponent(musicArtistOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        musicPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel19, jLabel20, jLabel21});

        musicPanelLayout.setVerticalGroup(
            musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(musicArtistOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(musicLengthOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(musicAlbumOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(musicProducerOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        specificPanelsHolder.add(musicPanel, "card5");

        buttonsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        addButton.setText("Add the Product");
        addButton.setPreferredSize(new java.awt.Dimension(127, 23));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(addButton);

        updateButton.setText("Update the Product");
        buttonsPanel.add(updateButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(genericPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(specificPanelsHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(genericPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(specificPanelsHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        IProduct newProduct = null;
        
        switch (currentProductType) {
            case Book:
                newProduct = createNewBook();
                break;
                
            case Game:
                newProduct = createNewGame();
                break;
                
            case Movie:
                newProduct = createNewMovie();
                break;
                
            case Music:
                newProduct = createNewMusic();
                break;
        }
        
        if (newProduct == null) {
            JOptionPane.showMessageDialog(null, "Could not create the product.");
            return;
        }
        
        ProductSystem.addProduct(newProduct);
    }//GEN-LAST:event_addButtonActionPerformed
    
//<editor-fold defaultstate="collapsed" desc="Generated code: variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField bookAuthorOutput;
    private javax.swing.JTextField bookIsbnOutput;
    private javax.swing.JTextField bookPageCountOutput;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JTextField gameDevOutput;
    private javax.swing.JTextField gameEngineOutput;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JTextField gamePlatformsOutput;
    private javax.swing.JPanel genericPanel;
    private javax.swing.JTextField genreOutput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField languageOutput;
    private javax.swing.JTextField movieBoxOfficeOutput;
    private javax.swing.JTextField movieCountryOutput;
    private javax.swing.JTextField movieDirectorOutput;
    private javax.swing.JTextField movieLengthOutput;
    private javax.swing.JPanel moviePanel;
    private javax.swing.JTextField movieProducerOutput;
    private javax.swing.JList<String> movieStarringOutput;
    private javax.swing.JTextField musicAlbumOutput;
    private javax.swing.JTextField musicArtistOutput;
    private javax.swing.JTextField musicLengthOutput;
    private javax.swing.JPanel musicPanel;
    private javax.swing.JTextField musicProducerOutput;
    private javax.swing.JTextField nameOutput;
    private javax.swing.JTextField priceOutput;
    private javax.swing.JTextField publisherOutput;
    private javax.swing.JTextField relasedateOutput;
    private javax.swing.JPanel specificPanelsHolder;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
