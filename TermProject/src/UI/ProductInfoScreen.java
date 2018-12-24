/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Products.IProduct;
import Products.Infos.BookInfo;
import Products.Infos.GameInfo;
import Products.Infos.MovieInfo;
import Products.Infos.MusicInfo;
import Products.MediumType;
import Products.Person;
import Products.ProductInfo;
import Products.ProductType;
import Users.UserSystem;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author bersl
 */
public class ProductInfoScreen extends javax.swing.JFrame {

    /**
     * Creates new form ProductInfoScreen
     */
    public ProductInfoScreen() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void fillWith(IProduct product) {
        fillGenericPanel(product.getProductInfo());
        fillSpecificPanel(product.getProductType(), product.getProductInfo());
        showSpecificPanel(product.getProductType());
    }

    public void setUpForAdd(MediumType medium, ProductType type) {
        clear();
        showSpecificPanel(type);
    }

    private void clear() {
        nameOutput.setText("");
        relasedateOutput.setText("");
        genreOutput.setText("");
        languageOutput.setText("");
        publisherOutput.setText("");
        priceOutput.setText("");

        bookIsbnOutput.setText("");
        bookAuthorOutput.setText("");
        bookPageCountOutput.setText("");

        gameDevOutput.setText("");
        gameEngineOutput.setText("");
        gamePlatformsOutput.setText("");

        movieBoxOfficeOutput.setText("");
        movieCountryOutput.setText("");
        movieDirectorOutput.setText("");
        movieLengthOutput.setText("");
        movieProducerOutput.setText("");

        movieStarringOutput.setModel(new DefaultListModel());

        musicAlbumOutput.setText("");
        musicArtistOutput.setText("");
        musicLengthOutput.setText("");
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
        movieLengthOutput.setText(Integer.toString(info.getLength()));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateButton = new javax.swing.JButton();
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
        specificPanelsGroup = new javax.swing.JLayeredPane();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Information");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        updateButton.setText("UPDATE");

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
                .addGap(58, 58, 58)
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
                .addContainerGap(148, Short.MAX_VALUE))
        );

        genericPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        genericPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {genreOutput, languageOutput, nameOutput, priceOutput, publisherOutput, relasedateOutput});

        genericPanelLayout.setVerticalGroup(
            genericPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genericPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
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

        specificPanelsGroup.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addContainerGap(25, Short.MAX_VALUE))
        );

        gamePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("PLATFORMS");

        gamePlatformsOutput.setEditable(false);
        gamePlatformsOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gamePlatformsOutputActionPerformed(evt);
            }
        });

        jLabel8.setText("GAME ENGINE");

        gameEngineOutput.setEditable(false);
        gameEngineOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameEngineOutputActionPerformed(evt);
            }
        });

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
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addContainerGap(25, Short.MAX_VALUE))
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
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
                                .addGap(0, 260, Short.MAX_VALUE))
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
                .addContainerGap(29, Short.MAX_VALUE))
        );

        musicPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setText("ARTIST");

        jLabel20.setText("LENGHT");

        jLabel21.setText("ALBUM");

        musicArtistOutput.setEditable(false);

        musicLengthOutput.setEditable(false);

        musicAlbumOutput.setEditable(false);

        javax.swing.GroupLayout musicPanelLayout = new javax.swing.GroupLayout(musicPanel);
        musicPanel.setLayout(musicPanelLayout);
        musicPanelLayout.setHorizontalGroup(
            musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(musicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(musicPanelLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(musicAlbumOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(musicPanelLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(musicLengthOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(musicPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(musicArtistOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        musicPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel19, jLabel20, jLabel21});

        musicPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {musicAlbumOutput, musicArtistOutput, musicLengthOutput});

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
                .addContainerGap(25, Short.MAX_VALUE))
        );

        specificPanelsGroup.setLayer(bookPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        specificPanelsGroup.setLayer(gamePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        specificPanelsGroup.setLayer(moviePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        specificPanelsGroup.setLayer(musicPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout specificPanelsGroupLayout = new javax.swing.GroupLayout(specificPanelsGroup);
        specificPanelsGroup.setLayout(specificPanelsGroupLayout);
        specificPanelsGroupLayout.setHorizontalGroup(
            specificPanelsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specificPanelsGroupLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(specificPanelsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moviePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(specificPanelsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(musicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        specificPanelsGroupLayout.setVerticalGroup(
            specificPanelsGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specificPanelsGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(moviePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(musicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(genericPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(specificPanelsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specificPanelsGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genericPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gamePlatformsOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamePlatformsOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gamePlatformsOutputActionPerformed

    private void gameEngineOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameEngineOutputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gameEngineOutputActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        updateButton.setVisible(UserSystem.getLoggedInUser().isAdmin());
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookAuthorOutput;
    private javax.swing.JTextField bookIsbnOutput;
    private javax.swing.JTextField bookPageCountOutput;
    private javax.swing.JPanel bookPanel;
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
    private javax.swing.JTextField nameOutput;
    private javax.swing.JTextField priceOutput;
    private javax.swing.JTextField publisherOutput;
    private javax.swing.JTextField relasedateOutput;
    private javax.swing.JLayeredPane specificPanelsGroup;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
