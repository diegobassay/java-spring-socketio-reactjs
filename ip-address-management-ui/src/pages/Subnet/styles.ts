import { Theme, createStyles, makeStyles } from '@material-ui/core/styles'

export const StylesForm = makeStyles((theme: Theme) =>
    createStyles({
    formPopup: {
        "& > *": {
        margin: theme.spacing(1),
        width: "25ch"
        }
    },
    }),
);

export const StylePopup = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 260,
    bgcolor: 'background.paper',
    boxShadow: 24,
    p: 4,
};

export const StyleDatagrid = { 
    height: 400, 
    width: '950px' 
};