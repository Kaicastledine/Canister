module MalBoxGUI where
-- |GUI libraries
  import Graphics.UI.Gtk hiding (disconnect)
  import Graphics.UI.Gtk.Glade

  import qualified MalBoxGUI
  import Paths_MalBox(getDataFileName)
-- |Start main code:
main :: FilePath -> IO ()
main gladepath = withSocketsDo $ handleSqlError $
  do initGUI                  -- Initialize GTK+ engine
    -- |Load the GUI from the Glade file
    gui <- loadGlade gladepath
    -- |Set up our events
    connectGui gui dbh
    -- |Run the GTK+ main loop; exits after GUI is done
    mainGUI
loadGlade gladepath =
  do -- |Load XML from glade path.
    -- |Note: crashes with a runtime error on console if fails!
    Just xml <- xmlNew gladepath

    -- |Load main window
    mw <- xmlGetWidget xml castToWindow "main_window"

    -- |Load all buttons

    [bxChoose, bxOpen, bxClose, bxMove, bxDelete, flAdd, flRevert, flDelete, mwHelp] <-
      mapM (xmlGetWidget xml castToButton)
      ["malbox_location", "box_open", "box_close", "box_move", "box_delete", "file_add", "file_revert", "file_delete", "help_button"]

    sw <- xmlGetWidget xml castToDialog "statusDialog"
    swl <- xmlGetWidget xml castToLabel "statusLabel"

    au <- xmlGetWidget xml castToDialog "addDialog"
    aue <- xmlGetWidget xml castToEntry "auEntry"

    return $ GUI mw mwAdd mwUpdate mwDownload mwFetch mwExit
      sw swOK swCancel swl au auOK auCancel aue
